/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marianne
 */
public class Base {
    int PosX,PosY, Width, Height;
    Color Color;   
    public Base(int PosX, int PosY, int Height, int Width)
    {
        this.PosX = PosX;
        this.PosY = PosY;
        this.Height = Height;
        this.Width = Width;
    }    
    public void desenhar(Graphics g)
    {
        
    }
    public int getWidth() {
        return Width;
    }
    public void setWidth(int Width) {
        this.Width = Width;
    }
     public int getHeight() {
        return Height;
    }    
     public void setHeight(int Height) {
        this.Height = Height;
    }
    public int getPosX() {
        return PosX;
    }
    public void setPosX(int PosX) {
        this.PosX = PosX;
    }
    public int getPosY() {
        return PosY;
    }
    public void setPosY(int PosY) {
        this.PosY = PosY;
    }
       public Color getColor() {
        return Color;
    }
    public void setColor(Color Color) {
        this.Color = Color;
    }

}
