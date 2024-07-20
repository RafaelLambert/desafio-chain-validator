package com.personatics.test;

import com.personatics.test.ChainValidator;
import com.personatics.test.Node;
import com.personatics.test.NodeType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criação de nós com inteiros
        Node intNode1 = new Node(1, NodeType.INTEGER);
        Node intNode2 = new Node(2, NodeType.INTEGER);
        Node intNode3 = new Node(23, NodeType.INTEGER);


        // Criação de nós com caracteres
        Node charNode1 = new Node("A", NodeType.STRING);
        Node charNode2 = new Node("B", NodeType.STRING);
        Node charNode3 = new Node("AB", NodeType.STRING);


        // Criação de listas de nós
        List<Node> intNodeList = new ArrayList<>();
        intNodeList.add(intNode1);
        intNodeList.add(intNode2);
        intNodeList.add(intNode3);
        intNodeList.add(new Node(2.2,NodeType.INTEGER));
//        intNodeList.add(charNode1);

        List<Node> charNodeList = new ArrayList<>();
        charNodeList.add(charNode1);
        charNodeList.add(charNode2);
        charNodeList.add(charNode3);

        ChainValidator.validate(charNodeList);
        ChainValidator.validate(intNodeList);

        // Exibição dos dados
        System.out.println("\nInteger Nodes: "+ intNodeList);
        for (Node node : intNodeList) {
            System.out.println(node.getValue().toString());
        }

        System.out.println("\nCharacter Nodes: " + charNodeList);
        for (Node node : charNodeList) {
            System.out.println(node.getValue());
        }
    }
}