// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.raumo0.languageplugindemo.psi.MoveTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MoveParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return LetBinding(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(EXPR, LITERAL_EXPR, PATH_EXPR, TUPLE_EXPR),
  };

  /* ********************************************************** */
  // CONST IDENTIFIER TypeAscription Initializer SEMICOLON
  public static boolean Const(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Const")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST, null);
    r = consumeTokens(b, 1, CONST, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, TypeAscription(b, l + 1));
    r = p && report_error_(b, Initializer(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LiteralExpr
  //        | PathExpr
  //        | TupleExpr
  public static boolean Expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = LiteralExpr(b, l + 1);
    if (!r) r = PathExpr(b, l + 1);
    if (!r) r = TupleExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  static boolean IdentifierPattern(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // EQ Expr
  public static boolean Initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Initializer")) return false;
    if (!nextTokenIs(b, EQ)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, INITIALIZER, r);
    return r;
  }

  /* ********************************************************** */
  // LET Pattern TypeAscription? Initializer? SEMICOLON
  static boolean LetBinding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetBinding")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LET);
    p = r; // pin = 1
    r = r && report_error_(b, Pattern(b, l + 1));
    r = p && report_error_(b, LetBinding_2(b, l + 1)) && r;
    r = p && report_error_(b, LetBinding_3(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeAscription?
  private static boolean LetBinding_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetBinding_2")) return false;
    TypeAscription(b, l + 1);
    return true;
  }

  // Initializer?
  private static boolean LetBinding_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetBinding_3")) return false;
    Initializer(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL
  //               | HEX_INTEGER_LITERAL
  //               | BOOL_LITERAL
  public static boolean LiteralExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, HEX_INTEGER_LITERAL);
    if (!r) r = consumeToken(b, BOOL_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean PathExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PATH_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // IdentifierPattern
  //           | TuplePattern
  public static boolean Pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pattern")) return false;
    if (!nextTokenIs(b, "<pattern>", IDENTIFIER, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = IdentifierPattern(b, l + 1);
    if (!r) r = TuplePattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  static boolean PrimitiveType(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // L_PAREN [<<comma_separated_list Expr>>] R_PAREN
  public static boolean TupleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TupleExpr")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && TupleExpr_1(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, TUPLE_EXPR, r);
    return r;
  }

  // [<<comma_separated_list Expr>>]
  private static boolean TupleExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TupleExpr_1")) return false;
    comma_separated_list(b, l + 1, MoveParser::Expr);
    return true;
  }

  /* ********************************************************** */
  // L_PAREN [<<comma_separated_list Pattern>>] R_PAREN
  public static boolean TuplePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TuplePattern")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && TuplePattern_1(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, TUPLE_PATTERN, r);
    return r;
  }

  // [<<comma_separated_list Pattern>>]
  private static boolean TuplePattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TuplePattern_1")) return false;
    comma_separated_list(b, l + 1, MoveParser::Pattern);
    return true;
  }

  /* ********************************************************** */
  // L_PAREN [<<comma_separated_list Type>>] R_PAREN
  public static boolean TupleType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TupleType")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && TupleType_1(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, TUPLE_TYPE, r);
    return r;
  }

  // [<<comma_separated_list Type>>]
  private static boolean TupleType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TupleType_1")) return false;
    comma_separated_list(b, l + 1, MoveParser::Type);
    return true;
  }

  /* ********************************************************** */
  // PrimitiveType
  //        | TupleType
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    if (!nextTokenIs(b, "<type>", IDENTIFIER, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = PrimitiveType(b, l + 1);
    if (!r) r = TupleType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON Type
  public static boolean TypeAscription(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAscription")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, TYPE_ASCRIPTION, r);
    return r;
  }

  /* ********************************************************** */
  // <<param>> (COMMA <<param>>)* COMMA?
  static boolean comma_separated_list(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && comma_separated_list_1(b, l + 1, _param);
    r = r && comma_separated_list_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA <<param>>)*
  private static boolean comma_separated_list_1(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comma_separated_list_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "comma_separated_list_1", c)) break;
    }
    return true;
  }

  // COMMA <<param>>
  private static boolean comma_separated_list_1_0(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean comma_separated_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comma_separated_list_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

}
