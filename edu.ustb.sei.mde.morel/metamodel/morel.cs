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
	//overrideProposalPostProcessor = "false";
	//disableTokenSorting = "true";
	overrideLaunchConfigurationMainTab = "false";
	overrideLaunchConfigurationDelegate ="false";
	additionalDependencies = "edu.ustb.sei.mde.emg, org.eclipse.ui.console, edu.ustb.sei.mde.modeling,edu.ustb.sei.commonutil";
	additionalExports = "edu.ustb.sei.mde.morel.resource.morel.execution";
	additionalLibraries = "choco-solver-3.2.1.jar";
}

TOKENS {
	
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$; 
	
	DEFINE SL_COMMENT $ '--'(~('\n'|'\r'|'\uffff'))* $;
	
	DEFINE ML_COMMENT $ '/*'.*'*/'$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
 
	DEFINE COLLECTION $('Sequence'|'Set'|'Bag'|'OrderedSet')$;

	DEFINE FRAGMENT TYPE  $'String'|'Integer'|'Boolean'|'Real'|'Char'|'Any'$;
	
	DEFINE DATA_TYPE $($+COLLECTION+$'(')*($+TYPE+$)')'*|($+COLLECTION+$'(')+($+IDENTIFIER+$)')'+$;

    DEFINE IDENTIFIER $('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*$;
    
    //DEFINE PATHNAME IDENTIFIER+$($+$':'$+IDENTIFIER+$)*$;
    
    DEFINE URINS $'@'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'/'|':'|'\.')+$;
        
    DEFINE INUMBER $('0'..'9')('0'..'1')*$;
    
    DEFINE RNUMBER $('0'..'9')+'\.'('0'..'9')+$;
    
}

TOKENSTYLES {
	"DATA_TYPE" COLOR #FF0000;
	"true" COLOR #FF8000;
	"false" COLOR #ff8000;
	"null" COLOR #ff0000;
	"invalid" COLOR #ff0000;
	
	"@this" COLOR #0000ff;
	"@id" COLOR #0000ff;
	
	"SL_COMMENT" COLOR #008000, ITALIC;
	"ML_COMMENT" COLOR #008000, ITALIC;
}

RULES {
	QueryModel ::= "querymodel" !0 (models !0)+ !0 (queries !0)*;
	
	TypedModel ::= "type" type[normal:"",readOnly:"readOnly",transient:"transient", viewOnly:"view",createOnly:"createOnly"] name[IDENTIFIER] #1 "<-" #1 package[URINS];
	
	Query ::= (active["active":"passive"])? "query" type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] name[IDENTIFIER] ("("parameters[IDENTIFIER] ("," #1 parameters[IDENTIFIER])*")")? "{" !2 "match" (!2 variables ("," !2 variables)*)?  (!2 linkConstraints ("," !2 linkConstraints)*)? (!2 additionalConstraints ("," !2 additionalConstraints)*)? (!2 "where" (!2 statements)+)?"}";
	
	ObjectVariable ::= name[IDENTIFIER] ":" (model[IDENTIFIER] "!")? type[IDENTIFIER];
	
	PrimitiveVariable ::= name[IDENTIFIER] ":" type[DATA_TYPE];
	
	ObjectVariableWithInit ::=  name[IDENTIFIER] ":" (model[IDENTIFIER] "!")? type[IDENTIFIER] "=" initExp:LetExp, ConditionExp, BooleanImpliesExp ;
	
	PrimitiveVariableWithInit ::=  name[IDENTIFIER] ":" type[DATA_TYPE] "=" initExp:LetExp, ConditionExp, BooleanImpliesExp;
	
	SimpleLinkConstraint ::= source[IDENTIFIER] "." reference[IDENTIFIER] ("[" id:PredefinedBindExp, BindExp, LetExp, ConditionExp, BooleanImpliesExp "]")? "=" target[IDENTIFIER];
	
	EnclosureLinkConstraint ::= source[IDENTIFIER] "." (forward[IDENTIFIER]("|" forward[IDENTIFIER])*) (":" types[IDENTIFIER]("," types[IDENTIFIER])*)? "*" "=" target[IDENTIFIER] ;
	
	PathConstraint ::= source[IDENTIFIER] "." (references[IDENTIFIER]("|" references[IDENTIFIER])*) (":" types[IDENTIFIER]("," types[IDENTIFIER])*)? "in" pathVariable[IDENTIFIER] ("[" (minLength[INUMBER] ",")? maxLength[INUMBER] "]")? "=" target[IDENTIFIER] ;
	
	
	VariableExp ::= referredVariable[IDENTIFIER] (path)?;
	
	NestedExp ::= "(" expression:LetExp, ConditionExp, BooleanImpliesExp ")" (path)?;
	
	//@Operator(type="primitive", weight="5", superclass="OclExpression") 
	IntegerLiteralExp ::= integerSymbol[INUMBER] (path)?;
	
	//@Operator(type="primitive", weight="5", superclass="OclExpression") 
	RealLiteralExp ::= realSymbol[RNUMBER] (path)?;
	
	StringLiteralExp ::= stringSymbol['\'','\'','\\'] (path)?;
	
	BooleanLiteralExp ::= boolSymbol["true":"false"] (path)?;
	
	UndefinedLiteralExp ::= value[NULL:"null", INVALID:"invalid"] (path)?;
	
	TypeLiteralExp ::= "@""("value[IDENTIFIER]")" (path)?;
	
	CollectionLiteralExp ::= type[COLLECTION] "{" ((literals:LetExp, ConditionExp, BooleanImpliesExp)( "," literals:LetExp, ConditionExp, BooleanImpliesExp)*)? "}" (path)?;
	
	EnumLiteralExp ::= "#" enumType[IDENTIFIER] "." enumSymbol[IDENTIFIER] (path)?;
	
	ArrayLiteralExp ::= "<" (elements:LetExp, ConditionExp, BooleanImpliesExp, ReflectiveVariableExp ("," elements:LetExp, ConditionExp, BooleanImpliesExp, ReflectiveVariableExp)*)? ">";

	FeaturePathExp ::= "." feature[IDENTIFIER] next?;
	
	OperationPathExp ::= separator[dot:"." , arrow:"->"] operation[IDENTIFIER] "(" (parameters:ReflectiveVariableExp, LetExp, ConditionExp, BooleanImpliesExp ("," parameters:ReflectiveVariableExp, LetExp, ConditionExp, BooleanImpliesExp)*)? ")" next?;
	
	IteratorPathExp ::= "->" type[forAll : "forAll", exists : "exists", select : "select", reject : "reject", collect : "collect", closure : "closure"] "(" firstVar ("," secondVar)? "|" bodyExp:LetExp, ConditionExp, BooleanImpliesExp ")" (next)?;
	

	LetExp ::= "let" variables ("," variables)* "in" inExp:LetExp, ConditionExp, BooleanImpliesExp ; 
	
	ConditionExp ::= "if" condition "then" thenBranch "else" elseBranch "endif";
	
	BooleanImpliesExp ::= left:BooleanOrExp (operator[implies:"implies", implies:"=>"] right:BooleanOrExp)? ;
	
	BooleanOrExp ::= children:BooleanAndExp (operators[or:"or", or:"||"] children:BooleanAndExp)? ;
	
	BooleanAndExp ::= children:RelationalExp (operators[and:"and", and:"&&"] children:RelationalExp)?;
	
	RelationalExp ::= left:AdditiveExp (operator[equal:"=", notEqual:"<>", notEqual:"!=", less:"<",lessOrEq:"<=",greater:">",greaterOrEq:">="] right:AdditiveExp)?;
	
	AdditiveExp ::= children:MultiplicativeExp (operators[plus : "+", minus : "-"] children:MultiplicativeExp)*;
	
	MultiplicativeExp ::= children (operators[multi : "*", div : "/"] children)*;
	
	UnaryExp ::= operator[plus : "+", minus : "-", not : "not", not:"!"]? child:AtomicExp ;
	
	BindExp ::= source "<-" valueExp:LetExp, ConditionExp, BooleanImpliesExp;
	
	PredefinedBindExp ::= source "<-" valueExp:LetExp, ConditionExp, BooleanImpliesExp;
	
	DeclarativeStatement ::= expression : PredefinedBindExp, BindExp, LetExp, ConditionExp, BooleanImpliesExp, ReflectiveVariableExp ";" ;
	
	IfStatement ::= "if" "(" condition ")"  thenStatement  ("else"  elseStatement )? ;
	
	ForStatement ::= "for" "(" iterator ";" terminationExp ";" (stepExp:LetExp, ConditionExp, BooleanImpliesExp)? ")" bodyStatement ;
	
	BlockStatement ::= "{" statements* "}" ;
	
	TransformationModel ::= "transformation" name[IDENTIFIER] models+ rules* ;
	
	Rule ::= (active["active":"passive"])? "rule" name[IDENTIFIER] ("("parameters[IDENTIFIER] ("," parameters[IDENTIFIER])*")")? "{" (patterns:Pattern)* "}" ;
	
	RuleGroup ::= (active["active":"passive"])? "group" name[IDENTIFIER] ("scope" scope[all:"all", staticRandom: "random", dynamicRandom : "random*"] ("for" scopeSize[INUMBER])?)? ("order" order[arbitrary:"default",sequential:"sequential",parallel:"parallel", random:"any"])? ("iterating" iteration[INUMBER])? ("repeating" repetition[INUMBER])? "{" rules* "}";
	
	Pattern ::= type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] "{" "match" (variables ("," variables)*)?  (linkConstraints ("," linkConstraints)*)? (additionalConstraints ("," additionalConstraints)*)? ("where"  (statements)+)? "}";
	
	PredefinedVariableExp ::= variable[this:"@this", id:"@id"] (path)?;
	
	ReflectiveVariableExp ::= "&" variable[IDENTIFIER];
	
	OrderConstraint ::= base[IDENTIFIER] "^" "<" (variables[IDENTIFIER] ("," variables[IDENTIFIER])*)? ">" ":" "<" (types[IDENTIFIER] "." references[IDENTIFIER]) ("," types[IDENTIFIER] "." references[IDENTIFIER])* ">";
	
	AllDifferentConstraint ::= "allDiff" "(" (variables[IDENTIFIER] ("," variables[IDENTIFIER])*)? ")" ;
}