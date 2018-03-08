package Modelo;

public class Cliente extends Persona{
    
    private String telefono_de_contacto;
    
    public Cliente(String nombre,int edad,String telefono)
    {
        super(nombre,edad);
        telefono_de_contacto =  telefono;
    }

    public String getTelefono_de_contacto() {
        return telefono_de_contacto;
    }

    public void setTelefono_de_contacto(String telefono_de_contacto) {
        this.telefono_de_contacto = telefono_de_contacto;
    }

    
    
    @Override
    public String mostrar(){
        return this.getNombre() + " " + this.getEdad() + " " + this.getTelefono_de_contacto();
    }
    
}
