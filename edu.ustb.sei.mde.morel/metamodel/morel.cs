SYNTAXDEF morel
FOR <http://www.ustb.edu.cn/sei/mde/morel> <morel.genmodel>
START QueryModel, TransformationModel//, BXRewritingModel,BxMorelModel

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
	additionalExports = "edu.ustb.sei.mde.morel.resource.morel.execution,edu.ustb.sei.mde.morel.resource.morel.conversion";
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
	
	"$this" COLOR #0000ff;
	"$id" COLOR #0000ff;
	
	"SL_COMMENT" COLOR #008000, ITALIC;
	"ML_COMMENT" COLOR #008000, ITALIC;
}

RULES {
	QueryModel ::= "querymodel" !0 (models !0)+ !0 (queries !0)*;
	
	TypedModel ::= "type" type[normal:"",readOnly:"readOnly",transient:"transient", viewOnly:"view",createOnly:"createOnly"] name[IDENTIFIER] #1 "<-" #1 package[URINS];
	
	Query ::= (active["active":"passive"])? "query" type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] name[IDENTIFIER] ("("parameters[IDENTIFIER] ("," #1 parameters[IDENTIFIER])*")")? "{" (!2 variables:ObjectVariable,ObjectVariableWithInit,PrimitiveVariable,PrimitiveVariableWithInit ("," !2 variables:ObjectVariable,ObjectVariableWithInit,PrimitiveVariable,PrimitiveVariableWithInit)*)?  (!2 linkConstraints:SimpleLinkConstraint,EnclosureLinkConstraint,PathConstraint ("," !2 linkConstraints:SimpleLinkConstraint,EnclosureLinkConstraint,PathConstraint)*)? (!2 additionalConstraints ("," !2 additionalConstraints)*)? (!2 "where" (!2 statements)+)?"}";
	
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
	
	TransformationModel ::= "transformation" name[IDENTIFIER] models+ rules:Rule,RuleGroup* ;
	
	Rule ::= (active["active":"passive"])? "rule" name[IDENTIFIER] ("("parameters[IDENTIFIER] ("," parameters[IDENTIFIER])*")")? "{" (patterns:Pattern)* "}" ;
	
	RuleGroup ::= (active["active":"passive"])? order[default:"default",sequential:"sequence",parallel:"parallel"]? "group" name[IDENTIFIER] ("scope" scope[all:"all", staticRandom: "random", dynamicRandom : "random*"] (scopeSize[INUMBER])?)? ("iterate"  maxIteration[INUMBER]? iteration[default:"",shuffle:"*"]?)? ("repeat" repetition[allMatches:"all",first:"first",randomOne:"one"])? "{" rules* "}";
	
	Pattern ::= type[LHS : "lhs", RHS : "rhs", NAC : "nac", PAC : "pac", PRE : "pre", POST : "post", LHS : ""] "{" (variables:ObjectVariable,ObjectVariableWithInit,PrimitiveVariable,PrimitiveVariableWithInit ("," variables:ObjectVariable,ObjectVariableWithInit,PrimitiveVariable,PrimitiveVariableWithInit)*)?  (linkConstraints:SimpleLinkConstraint,EnclosureLinkConstraint,PathConstraint ("," linkConstraints:SimpleLinkConstraint,EnclosureLinkConstraint,PathConstraint)*)? (additionalConstraints ("," additionalConstraints)*)? ("where"  (statements)+)? "}";
	
	PredefinedVariableExp ::= variable[this:"$this", id:"$id"] (path)?;
	
	ReflectiveVariableExp ::= "&" variable[IDENTIFIER];
	
	OrderConstraint ::= base[IDENTIFIER] "^" "<" (variables[IDENTIFIER] ("," variables[IDENTIFIER])*)? ">" ":" "<" (types[IDENTIFIER] "." references[IDENTIFIER]) ("," types[IDENTIFIER] "." references[IDENTIFIER])* ">";
	
	AllDifferentConstraint ::= "allDiff" "(" (variables[IDENTIFIER] ("," variables[IDENTIFIER])*)? ")" ;
	
	// BxRewriting

//	BXRewritingModel ::= "bxrewriting" name[IDENTIFIER] mode[get:"get", put:"put"] models+ rules* ;
	
//	BXRewritingRule ::= (active["active":"passive"])? "rule" name[IDENTIFIER] ("("parameters[IDENTIFIER] ("," parameters[IDENTIFIER])*")")? "{" nac* ("when" when)? ("source" source)? ("view" view)?  ("update" update)? ("unmatchs" unmatchSrc)? ("unmatchv" unmatchView)? "}" ; 
	
	Clause ::= "{" (statements)+ "}";
	
	//BxMorel
	
//	BxMorelModel ::= "bxupdate" name[IDENTIFIER] mode[get:"get", put:"put"] models:BxTypedModel+ rules* ;
	
//	BxMorelRule ::= (active["active":"passive"])? "rule" name[IDENTIFIER]  ("("parameters[IDENTIFIER] ("," parameters[IDENTIFIER])*")")? "{" ("when" when)? ("source" source)? ("view" view)? ("update" match)? ("unmatchs" unmatchSrc)? ("unmatchv" unmatchView)? "}";
	
//	Action ::= "{" (variables:ActionObjectVariable,PrimitiveVariable ("," variables:ActionObjectVariable,PrimitiveVariable)*)?  (linkConstraints:ActionSimpleLinkConstraint ("," linkConstraints:ActionSimpleLinkConstraint)*)? ("where"  (statements)+)? "}" ;
	
//	CaseStatement ::= "case" blocks+ ("otherwise" blocks)? ;
	
//	CaseBlock ::= condition? "->" action;
	
//	BxTypedModel ::= attribute[source:"source", view:"view", context:"context"] "type" type[normal:"",readOnly:"readOnly",transient:"transient", viewOnly:"view",createOnly:"createOnly"] name[IDENTIFIER] #1 "<-" #1 package[URINS];
	
//	ActionObjectVariable ::= actionType[keep:"",create:"+",delete:"-"] name[IDENTIFIER] ":" (model[IDENTIFIER] "!")? type[IDENTIFIER];
	
//	ActionSimpleLinkConstraint ::= actionType[keep:"",create:"+",delete:"-"] source[IDENTIFIER] "." reference[IDENTIFIER] ("[" id:PredefinedBindExp, BindExp, LetExp, ConditionExp, BooleanImpliesExp "]")? "=" target[IDENTIFIER];
}