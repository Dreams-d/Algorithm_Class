package Laicode.Class21_OOD4.InMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	protected List<Entry> contents;

	public Directory(String n, Directory p) {
		super(n,p);
		contents = new ArrayList<>();
	}

	protected List<Entry> getContents() {
		return contents;
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry e: contents) {
			size += e.size();
		}
		return size;
	}

	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}

	public void addEntry(Entry entry) {
		contents.add(entry);
	}

	public int numberOfFiles() {
		int count = 0;
		for (Entry e: contents) {
			if (e instanceof Directory) {
				count++;//Directory count as file
				Directory d = (Directory)e;
				count += d.numberOfFiles();
			} else if (e instanceof File) {
				count++;
			}
		}
		return count;
	}

	public Entry getChild(String name) {
		for (Entry e: contents) {
			if (e.name.equals(name)) {
				return e;
			}
		}
		return null;
	}
}
