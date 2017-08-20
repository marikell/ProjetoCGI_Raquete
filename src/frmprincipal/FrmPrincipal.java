/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmprincipal;

import classes.Bola;
import classes.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Marianne
 */
public class FrmPrincipal extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form FrmPrincipal
     */
    
    private boolean SetaEsquerda;
    private boolean SetaDireita;
    private int QuantidadeBolas = 3;
    
    public FrmPrincipal() {
        initComponents();
        createBufferStrategy(2);           
        Thread t = new Thread(this);
        t.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            SetaEsquerda = true;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
            {
            SetaDireita = true;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            SetaEsquerda = false;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
            {
            SetaDireita = false;
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }
    

    public static Color GenerateColor(){
        
        Random LRandom = new Random();
        return new Color(LRandom.nextInt(255),LRandom.nextInt(255),LRandom.nextInt(255));
    }

    @Override
    public void run() {
        
        java.util.ArrayList<Bola> Bolas = new ArrayList<Bola>();
        for(int i =0; i<3;i++){
            Random Random = new Random();
            int PosBolaX = Random.nextInt(getWidth()-30);
            int PosBolaY = Random.nextInt(getHeight()-30);
            boolean Boolean = Random.nextBoolean();
            Color Color = GenerateColor();
            Bolas.add(new Bola(PosBolaX, PosBolaY,Boolean,30,30));
        }
        
        
        int XPlayer,YPlayer,IncrementaX=1, IncrementaY=1;
        
        XPlayer = getWidth()/2-40;
        YPlayer = getHeight()-80;
        
       
        while(true){
            java.awt.Graphics g = getBufferStrategy().
            getDrawGraphics();
         
           g.setColor(Color.WHITE);
            g.fillRect(0,0,getWidth(),getHeight());
           Player Player = new Player(XPlayer, YPlayer,true, 15,80);
            g.setColor(GenerateColor());
            Player.desenhar(g);            
            XPlayer = XPlayer + IncrementaX; 
            if(SetaDireita)
                IncrementaX = 1;
            else
                if(SetaEsquerda)
                    IncrementaX = -1;
                else
                    IncrementaX = 0;
            
            if(XPlayer<5){
                if(SetaEsquerda)
                    IncrementaX=1;
                
                    
            }
            else if(XPlayer > getHeight()-5){
                if(SetaDireita)
                    IncrementaX=-1;
            }
            
            for(int i = 0; i< Bolas.size();i++){
                Bola Bola = Bolas.get(i);
                Bola.desenhar(g);
                Bola.mover(getWidth(),getHeight());
            }
                
                
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
               
            }
            g.dispose();
            getBufferStrategy().show();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
