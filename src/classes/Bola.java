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
    
    public Bola(int PosX, int PosY, boolean AAux, int Height, int Width){
    
        super(PosX, PosY, AAux, Height, Width);
    
    }
    
    @Override
    public void desenhar(Graphics g){
        
        g.fillOval(PosX, PosY, Width, Height);
    }
    public void mover(int w, int h, int PlayerX, int PlayerY, int PlayerWidth, int PlayerHeight, ArrayList<Bola> Bolas){
        
        if((PosX>=(PlayerX-Width) && PosX<=(PlayerX + Width)) && (PosY>= (PlayerY - Height) && PosY <= (PlayerY + Height))){
            AuxY = false;
        }
        else{
        //Se a bola estiver posicionada em 0
        if(PosX < Width){
            AuxX = true;
        }
        //Se a bola estiver posicionada no limite de X
        if(PosX >= (w - Width)){
            AuxX = false;
        }
       //Se a bola estiver posicionada em 0
        if(PosY < Height){
            AuxY = true;
        }
        //Se a bola estiver posicionada no limite de X
        if(PosY >= (h - Height)){
            AuxY = false;
            Bolas.remove(this);
        }
              if(PosY > PlayerY){
            AuxY = true;
        }
        //Devo rebater a bola quando a PosX da bola está entre a posição do Player
        }
        if(AuxX){
            PosX++;
        }
        else{
            PosX--;
        }
        //Se a bola estiver posicionada em menor que 0
        if(AuxY){
            PosY++;
        }
        else{
            PosY--;
        }
    }
    
}
