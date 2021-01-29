package com.tugas.adira.domain;


import javax.persistence.*;

import java.io.Serializable;


/**
 * A user.
 */
@Entity
@Table(name = "books")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul_buku", length = 60, nullable = false)
    private String judulBuku;

    @Column(name = "penerbit", length = 60, nullable = false)
    private String penerbit;

    @Column(name = "pengarang", length = 50)
    private String pengarang;

    @Column(name = "jenis_buku", length = 50)
    private String jenisBuku;

	public Long getId() {
		return id;
	}

	public String getJudulBuku() {
		return judulBuku;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public String getPengarang() {
		return pengarang;
	}

	public String getJenisBuku() {
		return jenisBuku;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public void setJenisBuku(String jenisBuku) {
		this.jenisBuku = jenisBuku;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jenisBuku == null) ? 0 : jenisBuku.hashCode());
		result = prime * result + ((judulBuku == null) ? 0 : judulBuku.hashCode());
		result = prime * result + ((penerbit == null) ? 0 : penerbit.hashCode());
		result = prime * result + ((pengarang == null) ? 0 : pengarang.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jenisBuku == null) {
			if (other.jenisBuku != null)
				return false;
		} else if (!jenisBuku.equals(other.jenisBuku))
			return false;
		if (judulBuku == null) {
			if (other.judulBuku != null)
				return false;
		} else if (!judulBuku.equals(other.judulBuku))
			return false;
		if (penerbit == null) {
			if (other.penerbit != null)
				return false;
		} else if (!penerbit.equals(other.penerbit))
			return false;
		if (pengarang == null) {
			if (other.pengarang != null)
				return false;
		} else if (!pengarang.equals(other.pengarang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", judulBuku=" + judulBuku + ", penerbit=" + penerbit + ", pengarang=" + pengarang
				+ ", jenisBuku=" + jenisBuku + "]";
	}

	
}

