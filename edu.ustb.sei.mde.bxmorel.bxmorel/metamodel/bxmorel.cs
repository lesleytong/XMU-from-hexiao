SYNTAXDEF bxmorel
FOR <http://www.ustb.edu.cn/sei/mde/bxmorel>
START EntityModel


RULES {
	EntityModel ::= "model" types*;
	Entity ::= abstract["abstract" : ""] "entity" name[] "{" features* "}";
	DataType ::= "datatype" name[] ";";
	Feature ::= kind[attribute:"att", reference:"ref", containment:"cont"] type[] name[] ";";
}