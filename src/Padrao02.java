class Material {
    private Estado estadoAtual;

    public Material(Estado estadoInicial) {
        estadoAtual = estadoInicial;
    }

    public void setState(Estado estado) {
        this.estadoAtual = estado;
    }

    public void esquenta() {
        estadoAtual.esquenta(this);
    }

    public void esfria() {
        estadoAtual.esfria(this);
    }
}

interface Estado {
    void esquenta(Material material);

    void esfria(Material material);
}

class EstadoSolido implements Estado {
    @Override
    public void esquenta(Material material) {
        System.out.println("Aquecendo... O Material está derretendo e se tornando líquido.");
        material.setState(new EstadoLiquido());
    }

    @Override
    public void esfria(Material material) {
        System.out.println("O Material já está no estado sólido. Não pode ser resfriado mais.");
    }
}

class EstadoLiquido implements Estado {
    @Override
    public void esquenta(Material material) {
        System.out.println("Aquecendo... O Material está evaporando e se tornando gasoso.");
        material.setState(new GaseousState());
    }

    @Override
    public void esfria(Material material) {
        System.out.println("Resfriando... O Material está congelando e se tornando sólido.");
        material.setState(new EstadoSolido());
    }
}

class GaseousState implements Estado {
    @Override
    public void esquenta(Material material) {
        System.out.println("O Material já está no estado gasoso. Não pode ser aquecido mais.");
    }

    @Override
    public void esfria(Material material) {
        System.out.println("Resfriando... O Material está condensando e se tornando liquido.");
        material.setState(new EstadoLiquido());
    }
}

public class Padrao02 {
    public static void main(String[] args) {
        Material material = new Material(new EstadoSolido());

        material.esquenta();
        material.esquenta();
        material.esfria();
        material.esfria();
    }
}
