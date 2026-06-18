package it.benefind.seatmap.dto;

public class UpdateUserDTO {
	private Integer id;
    private String nome;
    private String cf;
    private String password;

    public String getNome() {
        return nome;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}