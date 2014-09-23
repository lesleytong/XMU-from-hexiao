SYNTAXDEF morel
FOR <http://www.ustb.edu.cn/sei/mde/morel> <morel.genmodel>
START QueryModel, TransformationModel

IMPORTS { 
    // imports go here 
    ecore : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	usePredefinedTokens="false";
	reloadGeneratorModel="true";
	generateCodeFromGeneratorModel = "false";
	//disableTokenSorting = "true";
	overrideLaunchConfigurationMainTab = "false";
	overrideLaunchConfigurationDelegate ="false";
	additionalDependencies = "edu.ustb.sei.mde.emg, org.eclipse.ui.console, edu.ustb.sei.mde.modeling,edu.ustb.sei.commonutil";
	additionalExports = "edu.ustb.sei.mde.morel.resource.morel.execution";
}

TOKENS {
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$; 
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;

	DEFINE FRAGMENT COLLECTION $('Sequence'|'Set'|'Bag'|'OrderedSet')$;

	DEFINE FRAGMENT TYPE  $'String'|'Integer'|'Boolean'|'Real'|'Char'|'Any'$;

	DEFINE DATA_TYPE $($+COLLECTION+$'(')*($+TYPE+$)')'*|($+COLLECTION+$'(')+($+IDENTIFIER+$)')'+$;

    DEFINE IDENTIFIER $('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*$;
    
    //DEFINE PATHNAME IDENTIFIER+$($+$':'$+IDENTIFIER+$)*$;
    
    DEFINE URINS $'#'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'/'|':'|'\.')+'#'$;
        
    DEFINE INUMBER $('0'..'9')('0'..'1')*$;
    
    DEFINE RNUMBER $('0'..'9')+'\.'('0'..'9')+$;
    
}

TOKENSTYLES {
	"DATA_TYPE" COLOR #FF0000;
	"true" COLOR #FF8000;
	"false" COLOR #ff8000;
	
}

RULES {
	QueryModel ::= "querymodel" models+ queries*;
	TypedModel ::= "type" name[IDENTIFIER] "<-"  package[URINS];
	
	Query ::= "query" type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] name[IDENTIFIER] "{" "match" ":" (variables ("," variables)* ";")?  (linkConstraints ("," linkConstraints)* ";")? ("when" ":" (statements)+)?"}";
	
	ObjectVariable ::= name[IDENTIFIER] ":" (model[IDENTIFIER] "!")? type[IDENTIFIER];
	
	PrimitiveVariable ::= name[IDENTIFIER] ":" type[DATA_TYPE];
	
	ObjectVariableWithInit ::=  name[IDENTIFIER] ":" (model[IDENTIFIER] "!")? type[IDENTIFIER] "=" initExp:LetExp, ConditionExp, BooleanImpliesExp ;
	
	PrimitiveVariableWithInit ::=  name[IDENTIFIER] ":" type[DATA_TYPE] "=" initExp:LetExp, ConditionExp, BooleanImpliesExp;
	
	LinkConstraint ::= source[IDENTIFIER] "." reference[IDENTIFIER] "=" target[IDENTIFIER];
	
	VariableExp ::= referredVariable[IDENTIFIER] (path)?;
	
	NestedExp ::= "(" expression:LetExp, ConditionExp, BooleanImpliesExp ")" (path)?;
	
	//@Operator(type="primitive", weight="5", superclass="OclExpression") 
	IntegerLiteralExp ::= integerSymbol[INUMBER] (path)?;
	
	//@Operator(type="primitive", weight="5", superclass="OclExpression") 
	RealLiteralExp ::= realSymbol[RNUMBER] (path)?;
	
	StringLiteralExp ::= stringSymbol['\'','\'','\\'] (path)?;
	
	BooleanLiteralExp ::= boolSymbol["true":"false"] (path)?;

	FeaturePathExp ::= "." feature[IDENTIFIER] next?;
	
	OperationPathExp ::= separator[dot:"." , arrow:"->"] operation[IDENTIFIER] "(" (parameters:LetExp, ConditionExp, BooleanImpliesExp ("," parameters:LetExp, ConditionExp, BooleanImpliesExp)*)? ")" next?;
	
	IteratorPathExp ::= "->" type[forAll : "forAll", exists : "exists", select : "select", reject : "reject", collect : "collect", closure : "closure"] "(" firstVar ("," secondVar)? "|" bodyExp:LetExp, ConditionExp, BooleanImpliesExp ")" (next)?;
	
	LetExp ::= "let" variables ("," variables)* "in" inExp:LetExp, ConditionExp, BooleanImpliesExp ; 
	
	ConditionExp ::= "if" condition "then" thenBranch "else" elseBranch "endif";
	
	BooleanImpliesExp ::= left:BooleanOrExp (operator[implies:"implies"] right:BooleanOrExp)? ;
	
	BooleanOrExp ::= left:BooleanAndExp (operator[or:"or"] right:BooleanAndExp)? ;
	
	BooleanAndExp ::= left:RelationalExp (operator[and:"and"] right:RelationalExp)?;
	
	RelationalExp ::= left:AdditiveExp (operator[equal:"=", notEqual:"<>", notEqual:"!=", less:"<",lessOrEq:"<=",greater:">",greaterOrEq:">="] right:AdditiveExp)?;
	
	AdditiveExp ::= children:MultiplicativeExp (operators[plus : "+", minus : "-"] children:MultiplicativeExp)*;
	
	MultiplicativeExp ::= children (operators[multi : "*", div : "/"] children)*;
	
	UnaryExp ::= operator[plus : "+", minus : "-", not : "not"]? child:AtomicExp ;
	
	BindExp ::= source "<-" valueExp:LetExp, ConditionExp, BooleanImpliesExp;
	
	DeclarativeStatement ::= expression : BindExp, LetExp, ConditionExp, BooleanImpliesExp ";" ;
	
	IfStatement ::= "if" "(" condition ")"  thenStatement  ("else"  elseStatement )? ;
	
	ForStatement ::= "for" "(" iterator ";" terminationExp ";" (stepExp:LetExp, ConditionExp, BooleanImpliesExp)? ")" bodyStatement ;
	
	BlockStatement ::= "{" statements* "}" ;
	
	TransformationModel ::= "transformation" name[IDENTIFIER] models+ rules* ;
	
	Rule ::= "rule" name[IDENTIFIER] "{" (patterns:Pattern)* "}" ;
	
	Pattern ::= type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] "{" "match" ":" (variables ("," variables)* ";")?  (linkConstraints ("," linkConstraints)* ";")? ("when" ":" (statements)+)? "}";
	
}