SYNTAXDEF xmu
FOR <http://www.ustb.edu.cn/sei/mde/xmu> <metamol/xmu.genmodel>
START XMUModel

IMPORTS {
  ecore : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
//  reloadGeneratorModel = "false";
	additionalDependencies = "edu.ustb.sei.commonutil,org.eclipse.emf.ecore.xmi,edu.ustb.sei.mde.modeling";
	overrideLaunchConfigurationHelper = "false";
	overrideLaunchConfigurationMainTab = "false";
	overrideLaunchConfigurationDelegate = "false";
}

TOKENS {
  DEFINE URI $'<'('0'..'9'|'a'..'z'|'A'..'Z'|'_'|'-'|'/'|'\\'|'\.'|':')+'>'$;
  DEFINE PRIMITIVE $'String'|'Boolean'|'Integer'$;
  DEFINE BOOLEAN $'true'|'false'$;
  DEFINE NAME $(('a'..'z'|'A'..'Z'|'0'..'9'|'_')+'!')?('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*('@post')?$;
  DEFINE NUMBER $('0'..'9')+$;
  DEFINE SL_COMMENT $ '//'(~('\n'|'\r'|'\uffff'))* $;
  DEFINE ML_COMMENT $ '/*'.*'*/'$;
//  DEFINE LITERAL $('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*'::'('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*$;
}

TOKENSTYLES {
	 "NUMBER" COLOR #00ff00;
	 "BOOLEAN" COLOR #ff0000;
	 "PRIMITIVE" COLOR #ff0000;
	 "SL_COMMENT" COLOR #00ff00;
	 "ML_COMMENT" COLOR #00ff00;
}


RULES {
	XMUModel ::= ("import" packages[URI])* start+ rules* ;
	
	StartStatement ::= "start" rule[NAME] "(" root ("," root)*")" ";" ;
	
	StartRoot ::= tag[source:"source", view:"view", context:"context"] "[" id[NUMBER] "]"; 

	Rule ::= "rule" name[NAME] ("(" parameters ("," parameters)* ")")? "{" ("using" nVars("," nVars)*)? statement "}";
	
	Parameter ::= tag[source:"source", view:"view", context:"context", normal:""] variable[NAME];
	
	PrimitiveVariable ::= type[PRIMITIVE] name[NAME] ;
	
	ForStatement ::= "update" sPattern ("with" vPattern ("when" when (";" when)*)?)? "by" (actions (actions (actions)?)?) ;
	
	UpdatedStatement ::= "updated" "(" sVar[NAME] "," vVar[NAME] ")";
	
	VStatement ::= tag[match:"match", unmatchv:"unmatchv", unmatchs:"unmatchs"] "->" statement;
	
	Pattern ::= root ("[" guard: BooleanOrExpr,BooleanAndExpr,RelationalExpr,AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr "]")?;
	
	PatternNode ::= variable[NAME] ":" type[NAME] "{" (expr ("," expr)*)? "}";
	
	PatternReferenceExpr ::= reference[NAME] ("[" pos "]")? "=" node ;
	
	PatternEqualExpr ::= feature[NAME] ("[" pos "]")? "=" value;
	
	VariableExp ::= var[NAME] ("." path)*;
	
	FeaturePath ::= feature[NAME];
	
	OperationPath ::= operation[NAME] "(" (parameters ("," parameters)*)? ")";
	
	StringLiteral ::= value['\'','\'','\\'];
	
	EmptyLiteral ::= value[NullValue:"null", EmptyValue:"nil"];
	
	IntegerLiteral ::= value[NUMBER];
	
	BooleanLiteral ::= value[BOOLEAN];
	
	EnumLiteral ::= type[NAME] "::" value[NAME];
	
	BlockStatement ::= "{" (statements (";" statements)*)? "}" ;
	
	SwitchStatement ::= "switch" var[NAME] ("when" when (";" when)*)? "{" cases* "}";
	
	CasePatternStatement ::= "case" pattern "->" statement;
	
	CaseValueStatement ::= "case" expression "->" statement;
	
	RuleCallStatement ::= rule[NAME] "(" (actualParameters ("," actualParameters)*)? ")" ;
	
	UpdatePattern ::= "enforce" root;
	
	DeleteNode ::= "delete" variable[NAME];
	
	DeleteLink ::= "delete" source[NAME] "." feature[NAME] "=" target[NAME];
	
	BooleanOrExpr ::= operands:BooleanAndExpr,RelationalExpr, UnaryExpr,AtomicExpr ("or" operands:BooleanAndExpr,RelationalExpr,UnaryExpr,AtomicExpr)+;
	
	BooleanAndExpr ::= operands:RelationalExpr,AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr ("and" operands:RelationalExpr,AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr)+;
	
	RelationalExpr ::= left:AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr operator[equal:"=",less:"<",lessEqual:"<=",greater:">",greaterEqual:">="] right:AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr;
	
	AdditiveExpr ::= operands:MultiplicativeExpr,UnaryExpr,AtomicExpr (operators[add:"+",sub:"-"] operands:MultiplicativeExpr,UnaryExpr,AtomicExpr)+;
	
	MultiplicativeExpr ::= operands:UnaryExpr,AtomicExpr (operators[mul:"*",div:"/"] operands:UnaryExpr,AtomicExpr)+;
	
	ParenExpr ::= "(" body : BooleanOrExpr, BooleanAndExpr,RelationalExpr,AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr ")";
	
	UnaryExpr ::= operator[not:"not",minus:"-"] body:AtomicExpr;
	
	PrintStatement ::= "print" expr:BooleanOrExpr, BooleanAndExpr,RelationalExpr,AdditiveExpr,MultiplicativeExpr,UnaryExpr,AtomicExpr ;
}