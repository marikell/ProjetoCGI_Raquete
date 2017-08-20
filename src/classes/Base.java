/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Marianne
 */
public class Base {
    int PosX,PosY, Width, Height;
    boolean AuxX;
    boolean AuxY;
    Color Color;
    
    public Base()
    {
        this.AuxX = true;
        this.AuxY = true;
    }  
    
    
    
    public Base(int PosX, int PosY, boolean AAux, int Height, int Width)
    {
        this.PosX = PosX;
        this.PosY = PosY;
        this.AuxX = AAux;
        this.AuxY = AAux;
        this.Height = Height;
        this.Width = Width;
    }
    
    public void desenhar(Graphics g)
    {
        
    }
    
    public void mover(int w, int h)
    {
        if(PosX == w-30)
            AuxX=false;
        if(PosX == 0)
            AuxX=true;
        if(PosY == h-30)
            AuxY=false;
        if(PosY == 25)
            AuxY=true;

        if(AuxX==true)
            PosX++;
        else
            PosX--;
        if(AuxY==true)
            PosY++;
        else
            PosY--;
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

    public boolean getAuxX() {
        return AuxX;
    }

    public void setAuxX(boolean AuxX) {
        this.AuxX = AuxX;
    }

    public boolean getAuxY() {
        return AuxY;
    }

    public void setAuxY(boolean AuxY) {
        this.AuxY = AuxY;
    }
}
