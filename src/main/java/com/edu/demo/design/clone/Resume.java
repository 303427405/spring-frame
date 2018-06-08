package com.edu.demo.design.clone;

/**
 * 原型模式
 * Created By zhangyufei on 2018/6/8
 */
public class Resume extends ICloneable implements Cloneable{

    private String name;

    private String sex;

    private String age;

    private String timeArea;

    private String company;

    public Resume() {
    }

    public Resume(String name) {
        this.name = name;
    }

    @Override
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    @Override
    public void setWorkExperience(String timeArea, String company) {
        this.timeArea = timeArea;
        this.company = company;
    }

    @Override
    public void showMsg() {
        System.out.println("名字"+name);
        System.out.println(sex+age);
        System.out.println(timeArea+company);
    }

    public Object Clone(){
        try{
            return  (Object) super.clone();

        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e); // won't happen
        }

    }


    public static void main(String[] args){
        Resume resume = new Resume("zyf");
        resume.setPersonalInfo("男" ,"25");
        resume.setWorkExperience("杭州","牛B的公司");

        Resume resume1 = (Resume) resume.Clone();
        resume1.setPersonalInfo("dsf","asdf");

        resume.showMsg();
        resume1.showMsg();
    }
}
