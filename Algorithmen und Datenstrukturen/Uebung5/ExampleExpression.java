package Uebung5;

import aud.example.expr.*;
import aud.example.expr.Number;

//------------------------------------------------------------------//
public class ExampleExpression  {
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    ExpressionTree example =
            new ExpressionTree(new Plus(),
                    new ExpressionTree(new Times(),
                            new ExpressionTree(new Number(2)),
                            new ExpressionTree(new Number(5))),
                    new ExpressionTree(new Divide(),
                            new ExpressionTree(new Minus(),
                                    new ExpressionTree(new Number(-7)),
                                    new ExpressionTree(new Number(-1))),
                            new ExpressionTree(new Number(3))));

    System.out.println(example + "\n");
    System.out.println(example.inorder());
    System.out.println(example.postorder());
    System.out.println(example.preorder() + "\n");
    System.out.println(example.getValue() + "\n");

    ExpressionTreeTraversal app = new ExpressionTreeTraversal(example);

    if (args.length==0) app.traverse("inorder");
    else for (String type : args) app.traverse(type);

    app.halt("QUIT");
    System.exit(0);
  }
}