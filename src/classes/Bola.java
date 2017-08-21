/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Marianne
 */
public class Bola extends Base{
    private boolean AuxX;
    private boolean AuxY;
    //Construtor
    public Bola(int PosX, int PosY, boolean AAux, int Height, int Width){
        super(PosX, PosY,Height, Width);
        AuxX = AAux;
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
    
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.Color);
        g.fillOval(PosX, PosY, Width, Height);
    }
    public void mover(int w, int h, int PlayerX, int PlayerY, int PlayerWidth, int PlayerHeight, ArrayList<Bola> Bolas){
        
        if((PosX>(PlayerX-5) && PosX<(PlayerX + Width +5)) && (PosY>(PlayerY - Height-5) && PosY <(PlayerY)))
            AuxY = false;
        
        else{
        //Se a bola estiver posicionada em 0
        if(PosX < Width)
            AuxX = true;
        
        //Se a bola estiver posicionada no limite de X
        if(PosX >= (w - Width))
            AuxX = false;
        
       //Se a bola estiver posicionada em 0
        if(PosY < Height)
            AuxY = true;
        
        //Se a bola estiver posicionada no limite de y
        if(PosY >= (h - Height)){
            AuxY = false;
            Bolas.remove(this);
        }
        if(PosY > PlayerY) 
            AuxY = true;       
        }
        if(AuxX)
            PosX++;        
        else 
            PosX--;
        if(AuxY)
            PosY++;        
        else
            PosY--;
        
    }
    
}
