package Laicode.Class21_OOD4.InMemoryFileSystem;

public class File extends Entry{
	private String content;//or byte[]
	private int size;

	public File(String n, Directory p, int sz) {
		super(n,p);
		size = sz;
	}

	@Override
	public int size() {
		return size;
	}

	public String getContents() {
		return content;
	}

	public void setContents(String content) {
		this.content = content;
	}
}
