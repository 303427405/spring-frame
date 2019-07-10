package com.xkeshi.market.common.handler.xss.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xukai on 2017/7/14.
 */
public class XssDefenderUtils {

    private static Logger logger  =  LoggerFactory.getLogger(XssDefenderUtils.class);

    private static List<Pattern> XSS_INPUT_PATTERNS = new ArrayList<>();

    static {
        // Avoid anything between script tags
        XSS_INPUT_PATTERNS.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));

        // avoid iframes
        XSS_INPUT_PATTERNS.add(Pattern.compile("<iframe(.*?)>(.*?)</iframe>", Pattern.CASE_INSENSITIVE));

        // Avoid anything in a src='...' type of expression
        //XSS_INPUT_PATTERNS.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        //XSS_INPUT_PATTERNS.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        //XSS_INPUT_PATTERNS.add(Pattern.compile("src[\r\n]*=[\r\n]*([^>]+)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Remove any lonesome </script> tag
        XSS_INPUT_PATTERNS.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));

        // Remove any lonesome <script ...> tag
        XSS_INPUT_PATTERNS.add(Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Avoid eval(...) expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Avoid expression(...) expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Avoid background=expressions expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("background(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Avoid alert(...) expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("alert\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        // Avoid javascript:... expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));

        // Avoid vbscript:... expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE));

        // Avoid onload= expressions
        XSS_INPUT_PATTERNS.add(Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onerror(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onmouseover(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("<meta>(.*?)</meta>", Pattern.CASE_INSENSITIVE));

        /**---https://html5sec.org --*/

        /**H5 <form id="test"></form><button form="test" formaction="javascript:alert(1)">X</button>*/
        XSS_INPUT_PATTERNS.add(Pattern.compile("formaction(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onscroll(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("autofocus", Pattern.CASE_INSENSITIVE));

        /**这个向量是使焦点自动跳到输入元素上,触发焦点事件 - 无需用户交互*/
        XSS_INPUT_PATTERNS.add(Pattern.compile("onfocus(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onformchange(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("oninput(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("srcdoc(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("ontoggle(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onratechange(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onqt_error(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("onpageshow(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));

        XSS_INPUT_PATTERNS.add(Pattern.compile("to=", Pattern.CASE_INSENSITIVE ));
    }

    /**清理xss*/
    public static String sanitizerXSS(String value) {

        try {

            if (value != null) {
                // Avoid null characters
                value = value.replaceAll("\0", "");

                // test against known XSS input patterns
                for (Pattern xssInputPattern : XSS_INPUT_PATTERNS) {
                    value = xssInputPattern.matcher(value).replaceAll("");
                }
            }

        } catch (Exception ex) {
            logger.error("Could not strip XSS from value = " + value + " | ex = " + ex.getMessage());
        }
        return value;
    }

    /**转义xss*/
    public static String escapeXSS(String value) {
        try {
            //&amp;lt;script &amp;gt;alert(&#39;1&#39;)&amp;lt;/script&amp;gt; --> &lt;script &gt;alert('1')&lt;/script&gt;
            value = StringEscapeUtils.unescapeHtml4(value);
            //&lt;script &gt;alert('1')&lt;/script&gt;  --> <script >alert('1')</script>
            value = StringEscapeUtils.unescapeHtml4(value);
            //<script >alert('1')</script> -- > null
            return  StringEscapeUtils.escapeHtml4(SanitizerCharUtil.sanitizerChar(value));
        } catch (Exception ex) {
            logger.error("Could not strip XSS from value = " + value + " | ex = " + ex.getMessage());
        }
        return value;
    }

}
