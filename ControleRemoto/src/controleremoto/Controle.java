package controleremoto;

import javax.swing.JOptionPane;

public class Controle implements Controlador {
    
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //Construtor

    public Controle() {
        this.volume=50;
        this.ligado=false;
        this.tocando=false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    //metodos abstratos
    //@Override significa sobrescrever

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        int i;
        String[] barra = new String[getVolume()];
        String resultado = "";
        for (i=0;i<getVolume();i+=10){
            barra[i]="*";}
        for (i=0;i<getVolume();i+=10){
            resultado=resultado+"  "+barra[i];
        }
        
            
        JOptionPane.showMessageDialog(null,"--------MENU--------\n"+"Está ligado? "+ getLigado()+"\nVolume: "+getVolume()+resultado,"Menu",1);
    }

    @Override
    public void fecharMenu() {
        JOptionPane.showMessageDialog(null, "Fechando menu","Menu",1);
    }

    @Override
    public void maisVolume() {
        if(this.getLigado()) {
            this.setVolume(getVolume()+10);
        }
    }

    @Override
    public void menosVolume() {
         if(this.getLigado()) {
             this.setVolume(getVolume()-10);
         }
    }

    @Override
    public void ligarMudo() {
        if((this.getLigado())&&(this.getVolume()>0)) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if((this.getLigado())&&(this.getVolume()==0)) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if((this.getLigado())&&!(this.getTocando())) {
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if((this.getLigado())&&(this.getTocando())) {
            this.setTocando(false);
        }
    }
}
