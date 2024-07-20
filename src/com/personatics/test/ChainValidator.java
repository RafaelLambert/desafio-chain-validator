package com.personatics.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe para validação de listas de nós.
 *
 * Esta classe fornece métodos para validar uma lista de nós, garantindo que todos os nós
 * sejam do mesmo tipo e que os valores atendam a determinadas condições.
 */
public class ChainValidator {

    /**
     * Valida a lista de nós.
     *
     * Verifica se a lista não nula ou vazia.
     * Verifica se todos os nós têm o mesmo tipo.
     * categoriza os valores dos nós em conjuntos de valores de um caractere e de múltiplos caracteres.
     * Em seguida, valida se todos os caracteres presentes nos valores de múltiplos caracteres são formados
     * pelos valores de um caractere contido na lista.
     *
     * @param nodes A lista de nós a ser validada.
     * @return Verdadeiro se a lista atender aos critérios de validação, falso caso contrário.
     */
    public static boolean validate(List<Node> nodes){

        if (nodes == null || nodes.isEmpty()) {
            System.out.println("Lista está vazia ou é nula!");
            return false;
        }

        NodeType firstListType = nodes.get(0).getNodeType();



        Set<String> singleCharValues = new HashSet<>();
        Set<String> multiCharValues = new HashSet<>();

        for (Node node : nodes) {

            if (!nodeHaveSameType(node, firstListType)) {
                System.out.println("\nLista possui itens com diferentes tipos de dados!");
                return false;
            }

            categorizeNodeValues(node, singleCharValues, multiCharValues);
        }
        boolean isValidated = validateCharacterSets(singleCharValues, multiCharValues);

        System.out.println("\na validação desta lista é : " + isValidated);
        return isValidated;
    }

    /**
     * Verifica se o tipo do nó é o mesmo que o tipo esperado.
     *
     * @param node O nó a ser verificado.
     * @param expectedType O tipo esperado do nó.
     * @return Verdadeiro se o tipo do nó corresponder ao tipo esperado, falso caso contrário.
     */
    private static boolean nodeHaveSameType(Node node, NodeType expectedType) {

        return node.getNodeType() == expectedType;
    }

    /**
     * Categoriza o valor do nó em conjuntos de valores de um caractere ou múltiplos caracteres.
     *
     * @param node O nó a ser categorizado.
     * @param singleCharValues O conjunto de valores de um caractere.
     * @param multiCharValues O conjunto de valores de múltiplos caracteres.
     */
    private static void categorizeNodeValues(Node node, Set<String> singleCharValues, Set<String> multiCharValues) {

        String value = extractValueAsString(node);
        if (value.length() > 1) {
            multiCharValues.add(value);
        } else {
            singleCharValues.add(value);
        }

    }

    /**
     * Converte o valor do nó para string com base no tipo de dado do nó.
     *
     * @param node O nó de onde o valor será extraído.
     * @return O valor do nó como uma string.
     * @throws IllegalArgumentException Se o tipo do nó não for suportado.
     */
    private static String extractValueAsString(Node node) {
        switch (node.getNodeType()) {
            case STRING:
                return (String) node.getValue();
            case INTEGER:
                return String.valueOf((Integer) node.getValue());
            default:
                throw new IllegalArgumentException("Tipo de nó não permitido: " + node.getNodeType());
        }
    }
    
    /**
     * Valida se todos os caracteres presentes nos valores de múltiplos caracteres estão
     * presentes nos valores de um caractere.
     *
     * @param singleCharValues O conjunto de valores de um caractere.
     * @param multiCharValues O conjunto de valores de múltiplos caracteres.
     * @return Verdadeiro se todos os caracteres de múltiplos caracteres estiverem presentes
     *         nos valores de um caractere, falso caso contrário.
     */
    private static boolean validateCharacterSets(Set<String> singleCharValues, Set<String> multiCharValues) {
        for (String multiChar : multiCharValues) {
            for (char letter : multiChar.toCharArray()) {
                if (!singleCharValues.contains(String.valueOf(letter))) {
                    return false;
                }
            }
        }
        return true;
    }
}
