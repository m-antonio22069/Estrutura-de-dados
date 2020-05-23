
package clube_da_luta;

public class Lutador extends Pessoa implements ControleLutador {
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;
    
    /*
    Contrutor para um novo lutador
    */

    public void cadastrar(String titulo,String nome, String nacionalidade,int idade,float altura,
                          float peso,int vitorias, int derrotas, int empates) {
        
        this.setTitulo(titulo);
        this.setNome(nome);
        this.setNacionalidade(nacionalidade);
        this.setIdade(idade);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setCategoria();
        this.setVitorias(vitorias);
        this.setDerrotas(derrotas);
        this.setEmpates(empates);
    }
    
    
    //Apresentar informações detalhadas
    @Override
    public void apresentar(){
        System.out.println("-------------------*-------------------");
        System.out.println("|          Nome: "+getNome());
        System.out.println("|          Nacionalidade: "+getNacionalidade());
        System.out.println("|          Idade: "+getIdade());
        System.out.println("|          Altura: "+getAltura());
        System.out.println("|          Peso: "+getPeso());
        System.out.println("|          Categoria: "+getCategoria());
        System.out.println("|          Vitorias: "+getVitorias());
        System.out.println("|          Derrotas: "+getDerrotas());
        System.out.println("|          Empates: "+getEmpates());
        System.out.println("-------------------*-------------------");
    }
    
    //Mostra status e informaçoes basicas
    
    @Override
    public void status(){
        System.out.println(getTitulo()+ "|"+ getNome()+" é um peso "+this.getCategoria()+" com "+this.getVitorias()+" Vitorias "+""+getDerrotas()+" Derrotas "+getEmpates()+" Empates \n");
    }    
    
    //Metodos para ganhar, perder e empatar luta
    protected void ganharLuta(){
        this.setVitorias(this.getVitorias()+1);
    }
    
    protected void perderLuta(){
        this.setDerrotas(this.getDerrotas()+1);
    }
    
    protected void empatarLuta(){
        this.setEmpates(this.getEmpates()+1);
    }
    
    //Metodos especiais get e set
    protected String getCategoria() {
        return this.categoria;
    }

    protected void setCategoria() {
        if (this.getPeso()<52.2){
            this.categoria = "Invalido";
        }
        else if(this.getPeso()<=70.4){
            this.categoria="Leve";
        }
        else if (this.getPeso()<=83.9){
            this.categoria="Medio";
        }
        else if(this.getPeso()<=120.2){
            this.categoria="Pesado";
        }
        else{
            this.categoria="Invalido";
        }
    }

    private int getVitorias() {
        return vitorias;
    }

    private void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    private int getDerrotas() {
        return derrotas;
    }

    private void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    private int getEmpates() {
        return empates;
    }

    private void setEmpates(int empates) {
        this.empates = empates;
    }
    
}
