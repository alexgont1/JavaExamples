package Polymorphism;
//It's - same name but multiple forms (action/behavior)

//	2 types:
//1. Compile time / early binding / static binding / overloading
//	(it's just different names, all they are the same)
// 		Example: RBI class - 2 methods with same name BUT
//	different method signature (parameters)
//IQ1: Can we achieve overloading by keeping the method
//signature and changing the return type? Answer: NO!!! We'll
//get 'Duplicate method' error.
//-----------------------------------------------
//2. Runtime / late binding / dynamic binding / overriding
// We have different classes (with inheritance) and methods
// with same signature.
//IQ2: Can we change return type while performing overriding?
//Answer1: NO. If we change child primitive return type it 
//will be incompatible with parent type.
//Answer2:Yes, if return type is className and have Parent-child
//relationship (covariant)
//

public class Description {

}
