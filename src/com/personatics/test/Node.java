package com.personatics.test;

/**
 * Classe Node que armazena um valor e seu tipo correspondente.
 * O valor pode ser do tipo Integer ou String, determinado pelo NodeType.
 * Se o tipo de dado não corresponder ao NodeType, uma ClassCastException será lançada.
 */
public class Node{
    /**
     * O valor armazenado no nó. Pode ser um Integer ou uma String.
     */
    private Object value;

    /**
     * O tipo do nó, que especifica se o valor do node é um Integer ou uma String.
     */
    private NodeType nodeType;


    /**
     * Constrói um Node com os dados fornecidos e o NodeType.
     * Garante que o tipo de dado seja um Integer ou String, e corresponda ao NodeType.
     *
     * @param data O dado a ser armazenado no nó, deve ser um Integer ou uma String.
     * @param nodeType O tipo do nó, que especifica se o valor é um Integer ou uma String.
     * @throws ClassCastException se o tipo de dado não corresponder ao NodeType.
     */
    public Node(Object data, NodeType nodeType) {
        this.nodeType = nodeType;
        try {
            switch (nodeType){
                case INTEGER:
                    this.value = (Integer)data;
                    break;
                case STRING:
                    this.value = (String)data;
            }
        }catch (ClassCastException e){

            System.out.println(String.format("\nO dado '%s' precisa ser do tipo String ou Integer, e deve ser correspondente ao nodeType",data));
            throw new ClassCastException(e.getMessage());
        }


    }


    /**
     * Obtém o valor armazenado no nó.
     *
     * @return O valor armazenado no nó, pode ser um Integer ou uma String.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Obtém o tipo do nó.
     *
     * @return O NodeType do nó.
     */
    public NodeType getNodeType() {
        return nodeType;
    }

}
