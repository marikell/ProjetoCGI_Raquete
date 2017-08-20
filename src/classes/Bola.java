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
    
    
    @Override
    public void desenhar(Graphics g){
        
        g.fillOval(PosX, PosY, Width, Height);
    }
    
}
