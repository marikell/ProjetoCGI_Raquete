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



public class Player extends Base{
    
    public Player(int PosX, int PosY, boolean AAux, int Height, int Width){
    
        super(PosX, PosY, AAux, Height, Width);
    
    }
    @Override
    public void desenhar(Graphics g){        
        
    g.fillRect(PosX, PosY, Width, Height);
    }
}
