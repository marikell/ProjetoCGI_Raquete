/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Graphics;

/**
 *
 * @author Marianne
 */
public class Bola extends Base{
    
    public Bola(int PosX, int PosY, boolean AAux, int Height, int Width){
    
        super(PosX, PosY, AAux, Height, Width);
    
    }
    
    @Override
    public void desenhar(Graphics g){
        
        g.fillOval(PosX, PosY, Width, Height);
    }
    
    @Override
    public void mover(int w, int h){
        if(PosX == w-30)
            AuxX=false;
        if(PosX == 0)
            AuxX=true;
        if(PosY == h-30)
            AuxY=false;
        if(PosY == 25)
            AuxY=true;

        if(AuxY==true)
            PosX++;
        else
            PosX--;
        if(AuxX==true)
            PosY++;
        else
            PosY--;
    }
    
}
