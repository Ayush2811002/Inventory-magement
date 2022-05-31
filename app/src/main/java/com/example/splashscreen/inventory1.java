package com.example.splashscreen;

public class inventory1 {
public int id,qty;
public String iteam_Type,color;
public inventory1()
{


}
public inventory1(int id,int qty,String iteam_Type,String color){
    this.id=id;
    this.qty=qty;
    this.color=color;
    this.iteam_Type=iteam_Type;
}
public int getId()
{
    return id;
}
    public int getQty()
    {
        return qty;
    }
    public String getColor()
    {
        return color;
    }
    public String getIteam_Type()
    {
        return iteam_Type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setIteam_Type(String iteam_Type) {
        this.iteam_Type = iteam_Type;
    }
}
