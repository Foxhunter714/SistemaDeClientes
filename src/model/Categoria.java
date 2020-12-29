package model;

public class Categoria {
	private CategoriaEnum nombreCategoria;
	
	//TODO ¿este constructor es utilizado?
	public Categoria() {} 

	public Categoria(CategoriaEnum nombreCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
}
