package Uebung6;

import aud.example.expr.*;  //to extend ExpressionParser2
import aud.example.expr.Number;

//-----------------------------------------------------------------//
/**ExpressionParser which is able the process `power to`.*/
public class ExprWithPow extends ExpressionParser2 {
  
  @Override
  protected ExpressionTree factor(int level) {
    verbose(level,"<factor>");

    ExpressionTree tree=null;

    if (lookahead()==Tokenizer.NUMBER) {
      tree=new ExpressionTree
              (new Number(Double.parseDouble(matchedText())));
    }
    else if (lookahead()==Tokenizer.IDENTIFIER) {
      tree=new ExpressionTree(new Symbol(matchedText()));
    }
    else if (lookahead()==Tokenizer.LEFT_PAREN) {
      nextToken();
      tree=expression(level+1);
      expect(Tokenizer.RIGHT_PAREN,"closing parenthesis )");
    }
    else if (lookahead()==Tokenizer.PLUS) { // unary plus
      nextToken();
      return factor(level+1); // ignore: +x == x
    }
    else if (lookahead()==Tokenizer.MINUS) { // unary minus
      nextToken();
      return new ExpressionTree(new UnaryMinus(),factor(level+1),null);
    }
    else
      throw new SyntaxError(errorNear());

    nextToken();
    assert(tree!=null);

    // hinzugefügter Teil
    if (lookahead() == Tokenizer.POWER) {
      nextToken();
      return new ExpressionTree(new Power(), tree, factor(level+1));
    }
    //

    return tree;
  }

  //----------------------------------------------------------------//
  public static void main(String[] args) {
    String example = "(1^6-3)+2-3**4/3^3^2";
    
    System.out.println(example);
    
    ExprWithPow p = new ExprWithPow();
    p.setVerbose(true);
    ExpressionTree tree = p.parse(example);
    
    System.out.println(tree);
  }
}