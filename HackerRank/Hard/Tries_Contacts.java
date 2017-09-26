import java.util.*;/** * Created by rstanley on 9/20/2017. */public class Solution {    public static void main(String[] args) {        Scanner in = new Scanner(System.in);        ContactList contactList = new ContactList();        int n = in.nextInt();        for(int a0 = 0; a0 < n; a0++){            String op = in.next();            String contact = in.next();            contactList.execute(op, contact);        }    }}class ContactList{    private Node root = new Node();    public void execute(String operation, String str){        if(operation.equals("add")){            root.add(str, 0);        } else {            System.out.println(root.find(str, 0));        }    }}class Node{    public Character data;    public List<Node> childs = new ArrayList<>();    public int numberOfLeafs = 0;    public Node(){        super();    }    public Node(char firstChar){        super();        data = firstChar;    }    int find(String word, int index){        if(word.length() == index){            return numberOfLeafs;        } else {            for(int i=0; i<childs.size(); i++){                if(childs.get(i).data == word.charAt(index)){                    return childs.get(i).find(word, ++index);                }            }        }        return 0;    }    void add(String word, int index){        ++numberOfLeafs;        if(word.length() == index){            return;        } else {            for(int i=0; i<childs.size(); i++){                if(childs.get(i).data == word.charAt(index)){                    childs.get(i).add(word, ++index);                    return;                }            }            Node temp = new Node(word.charAt(index));            temp.add(word, ++index);            childs.add(temp);        }    }}
