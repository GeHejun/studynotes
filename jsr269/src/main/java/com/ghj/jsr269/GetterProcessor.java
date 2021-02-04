package com.ghj.jsr269;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author gehejun
 */
@SupportedAnnotationTypes(value = {"com.ghj.jsr269.Getter"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class GetterProcessor extends AbstractProcessor {

    private JavacTrees trees;
    private TreeMaker treeMaker;
    private Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.processingEnv = processingEnv;
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Getter.class);
        set.forEach(element -> {
            JCTree jcTree = trees.getTree(element);
            jcTree.accept(new TreeTranslator() {

                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                    List<JCTree.JCVariableDecl> jcVariableDeclList = List.nil();

                    for (JCTree tree : jcClassDecl.defs) {
                        if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                            JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl) tree;
                            jcVariableDeclList = jcVariableDeclList.append(jcVariableDecl);
                        }
                    }
                    jcVariableDeclList.
                            forEach(jcVariableDecl ->
                                    jcClassDecl.defs = jcClassDecl.defs.prepend(createGetterMethodDecl(jcVariableDecl))
                                            .prepend(createSetterMethodDecl(jcVariableDecl)));

                    super.visitClassDef(jcClassDecl);
                }

            });
        });

        return true;
    }

    private JCTree.JCMethodDecl createGetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {
        JCTree.JCAnnotation annotation = treeMaker.Annotation(treeMaker.Ident(names.fromString("Field")), List.nil());
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.getName())));
        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());
        return treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC, List.of(annotation)), generateGetterMethodName(jcVariableDecl.getName()),
                jcVariableDecl.nameexpr, List.nil(), List.nil(), List.nil(), body, null);
    }

    private JCTree.JCMethodDecl createSetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {
        JCTree.JCAnnotation annotation = treeMaker.Annotation(treeMaker.Ident(names.fromString("Field")), List.nil());
        JCTree.JCModifiers jcModifiers = treeMaker.Modifiers(Flags.PUBLIC, List.of(annotation));
        JCTree.JCExpression returnType = treeMaker.TypeIdent(TypeTag.VOID);
        List<JCTree.JCVariableDecl> parameters = List.nil();
        JCTree.JCVariableDecl param = treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER), jcVariableDecl.name, jcVariableDecl.vartype, null);
        param.pos = jcVariableDecl.pos;
        parameters = parameters.append(param);
        JCTree.JCStatement jcStatement = treeMaker.Exec(treeMaker.Assign(
                treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.name),
                treeMaker.Ident(jcVariableDecl.name)));
        List<JCTree.JCStatement> jcStatementList = List.nil();
        jcStatementList = jcStatementList.append(jcStatement);
        JCTree.JCBlock body = treeMaker.Block(0, jcStatementList);
        return treeMaker.MethodDef(jcModifiers, generateSetterMethodName(jcVariableDecl.getName()), returnType, List.nil(), parameters, List.nil(), body, null);
    }


    private Name generateGetterMethodName(Name name) {
        String s = name.toString();
        return names.fromString("get" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }

    private Name generateSetterMethodName(Name name) {
        String s = name.toString();
        return names.fromString("set" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }



}