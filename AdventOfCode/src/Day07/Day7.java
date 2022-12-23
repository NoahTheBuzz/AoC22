package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        partA();
        partB();
    }

    private static void partA(){
        try{
            Scanner sc = new Scanner(new File("src/Day07/input.txt"));

            int result = 0;
            Node start = new Node("/", null);
            Node currentNode = start;
            while(sc.hasNextLine()){

                String input = sc.nextLine();
                if (input.contains("dir")){
                    String[] splits = input.split(" ");
                    currentNode.addChild(new Node(splits[1], currentNode));
                }
                if (input.contains("cd")){
                    String[] splits = input.split(" ");
                    if(splits[2].equals("/")) {
                       continue;
                    }
                    currentNode = currentNode.getChild(splits[2]);
                }

            }
            System.out.println("Result: " + result);

        }catch(FileNotFoundException ignored){}
    }

    private static void partB(){

    }
}

class Node {
    private String name;
    private Node parent;
    private List<Node> childs = new LinkedList<>();
    private List<Integer> files = new LinkedList<>();

    public Node(String name, Node prev){
        this.name = name;
        this.parent = prev;
    }

    public String getName(){
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public Node getChild(String name){
        for(int i = 0; i < childs.size(); i++){
            if(childs.get(i).getName().equals(name)){
                return childs.get(i);
            }
        }
        return null;
    }

    public List<Integer> getFiles() {
        return files;
    }

    public int getSizeOfDirectory(){
        int value = 0;

        if (!files.isEmpty()) {
            for (int i = 0; i < files.size(); i++) {
                value += files.get(i);
            }
        }

        if (!childs.isEmpty()) {
            for (int i = 0; i < childs.size(); i++) {
                value += childs.get(i).getSizeOfDirectory();
            }
        }

        return value;
    }

    public void addFile(int size){
        this.files.add(size);
    }

    public void addChild(Node newNode){
        this.childs.add(newNode);
    }
}
