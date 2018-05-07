package com.p2.stack;

import java.util.*;

/**
 * Created by I335831 on 5/7/2018.
 * TO evaluate an Prefix expression which has Integers and Binary operators
 *
 * SPOILER NOTE: We can reverse expression and evaluate the expression treating as a postfix expression
 * But here I am trying to solve it using a Operator and a Operand stack
 */
public class PrefixEvaluation {

    private static final String EMPTY_STRING = "";
    private static final String OPERATOR = "OPERATOR";
    private static final String OPERAND = "OPERAND";
    private static Set<Character> OPERATOR_SET = new HashSet<Character>();
    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;
    private List<String> charTypeList = new ArrayList<String>();

    static {
        OPERATOR_SET.add('+');
        OPERATOR_SET.add('*');
        OPERATOR_SET.add('/');
        OPERATOR_SET.add('-');
    }

    public void setOperandStack(Stack<Integer> operandStack) {
        this.operandStack = operandStack;
    }

    public void setOperatorStack(Stack<Character> operatorStack) {
        this.operatorStack = operatorStack;
    }

    public int evaluatePrefix(String prefixExpr) throws Exception {//example +*234(=> 2*3+4) or +2*34( => 2+3*4)
        if(prefixExpr == null || prefixExpr.equals(EMPTY_STRING)){
            throw new Exception("Input is null");
        }

        for(int i = 0 ; i < prefixExpr.length() ; i++){
            Character currentChar = prefixExpr.charAt(i);
            if(isOperator(currentChar)){
                operatorStack.add(currentChar);
                charTypeList.add(OPERATOR);
            } else {
                operandStack.add(Integer.parseInt(currentChar.toString()));//Assuming We have only operators and integers in input expression
                charTypeList.add(OPERAND);
            }

            evaluateExpressionRecursivelyWhenOperatorOperandOperandSequenceMatched();
        }

        evaluateExpressionRecursivelyWhenOperatorOperandOperandSequenceMatched();//When ALl characters from prefix are iterated

        assert operandStack.size() == 1;
        return operandStack.pop();
    }

    private void evaluateExpressionRecursivelyWhenOperatorOperandOperandSequenceMatched() throws Exception {
        while (isOperatorOperandOperandSequenceMatched()){
            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            Character operator = operatorStack.pop();
            cleanUpOperatorOperandOperandSequenceFromList();
            operandStack.push(evaluate(operand1, operand2, operator));
            charTypeList.add(OPERAND);
        }
    }

    private void cleanUpOperatorOperandOperandSequenceFromList() {
        int listSize = charTypeList.size();
        charTypeList.remove(listSize - 1);
        charTypeList.remove(listSize - 2);
        charTypeList.remove(listSize - 3);
    }

    private Integer evaluate(int operand1, int operand2, Character operator) throws Exception {
        int result ;
        switch (operator){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                throw new Exception("Invalid Operator found");
        }

        return result;
    }

    private boolean isOperatorOperandOperandSequenceMatched() {
        boolean flag = false;
        int listSize = charTypeList.size();

        if(listSize >= 3
                && OPERATOR.equals(charTypeList.get(listSize - 3))
                && OPERAND.equals(charTypeList.get(listSize - 2))
                && OPERAND.equals(charTypeList.get(listSize - 1))) {
            flag = true;
        }
        return flag;
    }

    private static boolean isOperator(Character character){
        return OPERATOR_SET.contains(character);
    }

    public static void main(String[] args) throws Exception {
        PrefixEvaluation prefixEvaluation = new PrefixEvaluation();
        prefixEvaluation.setOperandStack(new Stack<Integer>());
        prefixEvaluation.setOperatorStack(new Stack<Character>());

        System.out.println("Prefix expression %s Value is : " + prefixEvaluation.evaluatePrefix("+*234"));
        System.out.println("Prefix expression %s Value is : " + prefixEvaluation.evaluatePrefix("+2*34"));
    }
}
