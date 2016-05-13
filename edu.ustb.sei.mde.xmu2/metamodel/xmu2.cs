SYNTAXDEF xmu2
FOR <http://www.ustb.edu.cn/sei/mde/xmu2><xmu2.genmodel>
START TransformationModel

// each time the text resource is regenerated, add the validity checker to the ui plugin

IMPORTS {
	ecore:<http://www.eclipse.org/emf/2002/Ecore>
	statement:<http://www.ustb.edu.cn/sei/mde/xmu2/statement> <xmu2.genmodel>
	pattern:<http://www.ustb.edu.cn/sei/mde/xmu2/pattern> <xmu2.genmodel>
	expression:<http://www.ustb.edu.cn/sei/mde/xmu2/expression> <xmu2.genmodel>
	common:<http://www.ustb.edu.cn/sei/mde/xmu2/common> <xmu2common.genmodel>

}

OPTIONS {
	additionalDependencies = "edu.ustb.sei.commonutil,org.eclipse.emf.ecore.xmi,edu.ustb.sei.mde.modeling";
	overrideBuilder = "false";
	overrideLaunchConfigurationMainTab = "false";
	overrideLaunchConfigurationDelegate = "false";
}

TOKENS {
  DEFINE TYPE $'String'|'Boolean'|'Integer'|'OclAny'|'Resource'|(('a'..'z'|'A'..'Z'|'0'..'9'|'_')+'!'('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*)$;
  DEFINE BOOLEAN $'true'|'false'$;
  DEFINE NAME $('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*('@post')?$;
  DEFINE NUMBER $('0'..'9')+$;
  DEFINE SL_COMMENT $ '//'(~('\n'|'\r'|'\uffff'))* $;
  DEFINE ML_COMMENT $ '/*'.*'*/'$;
  DEFINE OBJ_URI $'@'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'\\'|'\.'|':'|'#')*$;
}

TOKENSTYLES {
	 "NUMBER" COLOR #00ff00;
	 "BOOLEAN" COLOR #ff0000;
	 "TYPE" COLOR #0000ff;
	 "SL_COMMENT" COLOR #008000;
	 "ML_COMMENT" COLOR #008000;
	 "OBJ_URI" COLOR #4080C0;
//	 "URI" COLOR #4080C0, BOLD; 
}

RULES {
	TransformationModel ::= "module" name[NAME] ("import" packages['<','>','\\'])* (entryPoints)* (rules)*;
	
	EntryPoint ::= "entry" rule[NAME] "(" parameters ("," parameters)* ")" ;
	
	EntryData ::= tag[source:"source",view:"view"] "[" index[NUMBER]  (fragment[OBJ_URI])? "]";
	
	ModelRule ::= active["top" : ""] "rule" name[NAME] "(" (parameters ("," parameters)*)? ")" "{" (variableDeclarations ";")* statement? "}";
	
	ArithmeticRule ::= "function" name[NAME] "(" (parameters ("," parameters)*)? ")" "{" statements* "}";
	
	VariableDeclaration ::= name[NAME] ":" type[TYPE];
	Parameter ::= tag[source:"source",view:"view",normal:""] name[NAME] ":" type[TYPE];
	
	//Pattern
	pattern.Pattern ::= root ("[" guard:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression "]")?;
	pattern.PatternNode ::= variable ("{" (expressions ("," expressions)*)? "}")?;
	pattern.ObjectPatternExpression ::= feature[NAME] (selector)? (position)? "=" targetNode;
	pattern.PropertyPatternExpression ::= feature[NAME] (selector)? (position)? "=" targetExpression:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression;
	
	//Expression
	
	expression.LoopPath ::= "->" operator[select:"select", forAll:"forAll", exists:"exists"] "(" variable "|" body:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression ")";
	expression.FeaturePath ::= "." feature[NAME];
	expression.OperationPath ::= "." operation[NAME] "(" (parameters:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression ("," parameters:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression)*)? ")";
	expression.PositionPath ::= "->" type[first:"first", last:"last", at:"at"] "(" value:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression? ")";
	
	expression.VariableExpression ::= variable[NAME];
	
	expression.PathExpression ::= host:expression.VariableExpression,expression.ConstantExpression, expression.ParenExpression path+;
	
	expression.EmptyExpression ::= type[nullValue:"null",emptyValue:"undefined"];
	expression.StringLiteralExpression ::= value['\'','\'','\\'];
	expression.IntegerLiteralExpression ::= value[NUMBER];
	expression.BooleanLiteralExpression ::= value[BOOLEAN];
	expression.EnumLiteralExpression ::= type[TYPE] "::" value[NAME];
	expression.ObjectURIExpression ::= object[OBJ_URI];
	
	expression.ParenExpression ::= "(" body : expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression ")";
	
	expression.UnaryExpression ::= operator[not:"not",minus:"-"] body:expression.PathExpression,expression.AtomicExpression;
	expression.MultiplicativeExpression ::= operands:expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression (operators[mul:"*",div:"/"] operands:expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression)+ ;
	expression.AdditiveExpression ::= operands:expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression (operators[add:"+",sub:"-",append:"++"] operands:expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression)+ ;
	expression.RelationalExpression ::= left:expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression operator[equal:"=",less:"<",lessEqual:"<=",greater:">",greaterEqual:">="] right:expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression ;
	expression.BooleanAndExpression ::= operands:expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression ("and" operands:expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression)+ ;
	expression.BooleanOrExpression ::= operands:expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression ("or" operands:expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression,expression.AtomicExpression)+ ;
	
	
	//Statements
	statement.BlockStatement ::= "{" (body (";" body)*)? "}";
	statement.UpdateStatement ::= "update" source "with" view "by" clauses+;
	statement.SwitchStatement ::= "switch" "(" root ")" "{" cases+ "}" ;
	statement.UpdateClause ::=  type[match:"match",unmatchs:"unmatchs",unmatchv:"unmatchv",default:"default"] "->" statement;
	statement.PatternCaseClause ::= "case" condition "->" action;
	statement.ExpressionCaseClause ::= "case" condition:expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression "->" action;
	statement.DeleteNodeStatement ::= "delete" node;
	statement.DeleteLinkStatement ::= "delete" source "." feature[NAME] "=" target:expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression;
	statement.EnforcePatternStatement ::= "enforce" pattern;
	statement.ForEachStatement ::= "foreach" pattern "->" action;
	statement.RuleCallStatement ::= rule[NAME] "(" (parameters:expression.PathExpression,expression.AtomicExpression ("," parameters:expression.PathExpression,expression.AtomicExpression)*)? ")";
	statement.Skip ::= "skip";
	statement.DefaultCaseClause ::= "otherwise" "->" action;
	statement.AssignStatement ::= updatedVariable "::=" value: expression.BooleanOrExpression,expression.BooleanAndExpression,expression.RelationalExpression,expression.AdditiveExpression,expression.MultiplicativeExpression,expression.UnaryExpression,expression.PathExpression, expression.AtomicExpression;
}