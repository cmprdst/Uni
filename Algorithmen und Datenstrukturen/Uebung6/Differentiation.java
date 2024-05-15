package Uebung6;

import aud.*;
import aud.example.expr.*;
import aud.example.expr.AtomicExpression.Type;
import aud.example.expr.Number;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
 `ExpressionTree` with respect to a user specified variable.*/
public class Differentiation {
  //----------------------------------------------------------------//
  public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
    if (t == null) return null;
    
    if (t.isLeaf()) {
      if        (t.getData().getType().equals(Type.TNumber))  return new ExpressionTree(new Number(0));
      else if   (t.getData().getType().equals(Type.TSymbol)) {
        if      (t.getData().toString().equals("-" + var))    return new ExpressionTree(new Number(-1));
        else if (t.getData().toString().equals(var))          return new ExpressionTree(new Number(1));
        else                                                  return new ExpressionTree(new Number(0));
      }
    }
    
    return switch (t.getData().getType()) {
      case OpPlus, OpMinus, OpUnaryMinus  -> differentiateSum(t, var);
      case OpTimes                        -> differentiateProduct(t, var);
      default                             -> { System.out.println("Only sums and products are allowed!"); yield null; }
    };
  }
  
  private static ExpressionTree differentiateSum(BinaryTree<AtomicExpression> t, String var) {
    ExpressionTree diffLeft   = differentiate(t.getLeft(), var);
    ExpressionTree diffRight  = differentiate(t.getRight(), var);
    
    if (t.getData().getType().equals(Type.OpPlus)) return new ExpressionTree(new Plus(), diffLeft, diffRight);
    else                                           return new ExpressionTree(new Minus(), diffLeft, diffRight);
  }
  
  private static ExpressionTree differentiateProduct(BinaryTree<AtomicExpression> t, String var) {
    ExpressionTree diffLeft   = differentiate(t.getLeft(), var);
    ExpressionTree right      = (ExpressionTree) t.getRight();
    ExpressionTree left       = (ExpressionTree) t.getLeft();
    ExpressionTree diffRight  = differentiate(t.getRight(), var);
    
    ExpressionTree diffLeft_Times_right = new ExpressionTree(new Times(), diffLeft, right);
    ExpressionTree left_Times_diffRight = new ExpressionTree(new Times(), left, diffRight);
    
    return new ExpressionTree(new Plus(), diffLeft_Times_right, left_Times_diffRight);
  }
  
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    ExpressionTree example =  new ExpressionTree(new Times(),
                              new ExpressionTree(new Symbol("-x")), new ExpressionTree(new Symbol("y")));
    
    System.out.println(example);
    System.out.println(differentiate(example, "x"));
    System.out.println(differentiate(example, "y"));
    
    ExpressionTree example1 =  new ExpressionTree(new Plus(),
            new ExpressionTree(new Symbol("-x")), new ExpressionTree(new Symbol("y")));
    
    System.out.println(differentiate(example1, "x"));
    
    ExpressionTree example2 =  new ExpressionTree(new Divide(),
            new ExpressionTree(new Symbol("-x")), new ExpressionTree(new Symbol("y")));
    
    System.out.println(differentiate(example2, "x"));
  }
}