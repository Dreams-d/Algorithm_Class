package Laicode.Class21_OOD4.InMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	private final Directory root;
	public FileSystem() {
		root = new Directory("/", null);
	}

	/**
	 * resolve a path like /foo/bar
	 */
	private List<Entry> resolve(String path) {
		assert path.startsWith("/");
		String[] components = path.substring(1).split("/");
		List<Entry> entries = new ArrayList<>(components.length + 1);
		entries.add(root);

		Entry entry = root;
		for (String component: components) {
			if (entry == null || !(entry instanceof Directory)) {
				//在中间如果有不存在的dir会直接在这里报错
				throw new IllegalArgumentException("invalid path: " + path);
			} else {
				if (!component.isEmpty()) {
					entry = ((Directory)entry).getChild(component);
					entries.add(entry);
				}
			}
		}
		return entries;
	}

	public void mkdir(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("Directory already exists: " + path);
		}

		String[] components = path.split("/");
		final String dirName = components[components.length - 1];
		final Directory parent = (Directory)entries.get(entries.size() - 2);
		Directory newDir = new Directory(dirName, parent);
		parent.addEntry(newDir);
	}

	public void createFile(String path) {
		assert !path.endsWith("/");
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("File already exists: " + path);
		}

		final String fileName = path.substring(path.lastIndexOf("/") + 1);
		final Directory parent = (Directory)entries.get(entries.size() - 2);
		File file = new File(fileName, parent, 0);
		parent.addEntry(file);
	}

	public void delete(String path) {
		List<Entry> entries = resolve(path);
		Entry toDelete = entries.get(entries.size() - 1);
		Directory parent = (Directory)entries.get(entries.size() - 2);
		parent.deleteEntry(toDelete);
	}

	public int count() {
		return root.numberOfFiles();
	}

	//list all the immediate children of the directory specified by the given path
	//Entry[] 作为output封装性不好
	// improve: a new class, Entry status的list
	public Entry[] list(String path) {
		List<Entry> entries = resolve(path);
		Entry endNode = entries.get(entries.size() - 1);
		if (!(endNode instanceof Directory)) {
			throw new IllegalArgumentException("Not an directory to list");
		}

		Directory parent = (Directory)endNode;
		return (Entry[])parent.contents.toArray();
	}
}
