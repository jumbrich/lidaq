/**
 *
 */
package ie.deri.urq.lidaq;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.yars.nx.Variable;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.sparql.algebra.OpVisitor;
import com.hp.hpl.jena.sparql.algebra.op.OpAssign;
import com.hp.hpl.jena.sparql.algebra.op.OpBGP;
import com.hp.hpl.jena.sparql.algebra.op.OpConditional;
import com.hp.hpl.jena.sparql.algebra.op.OpDatasetNames;
import com.hp.hpl.jena.sparql.algebra.op.OpDiff;
import com.hp.hpl.jena.sparql.algebra.op.OpDisjunction;
import com.hp.hpl.jena.sparql.algebra.op.OpDistinct;
import com.hp.hpl.jena.sparql.algebra.op.OpExt;
import com.hp.hpl.jena.sparql.algebra.op.OpExtend;
import com.hp.hpl.jena.sparql.algebra.op.OpFilter;
import com.hp.hpl.jena.sparql.algebra.op.OpGraph;
import com.hp.hpl.jena.sparql.algebra.op.OpGroup;
import com.hp.hpl.jena.sparql.algebra.op.OpJoin;
import com.hp.hpl.jena.sparql.algebra.op.OpLabel;
import com.hp.hpl.jena.sparql.algebra.op.OpLeftJoin;
import com.hp.hpl.jena.sparql.algebra.op.OpList;
import com.hp.hpl.jena.sparql.algebra.op.OpMinus;
import com.hp.hpl.jena.sparql.algebra.op.OpNull;
import com.hp.hpl.jena.sparql.algebra.op.OpOrder;
import com.hp.hpl.jena.sparql.algebra.op.OpPath;
import com.hp.hpl.jena.sparql.algebra.op.OpProcedure;
import com.hp.hpl.jena.sparql.algebra.op.OpProject;
import com.hp.hpl.jena.sparql.algebra.op.OpPropFunc;
import com.hp.hpl.jena.sparql.algebra.op.OpQuadPattern;
import com.hp.hpl.jena.sparql.algebra.op.OpReduced;
import com.hp.hpl.jena.sparql.algebra.op.OpSequence;
import com.hp.hpl.jena.sparql.algebra.op.OpService;
import com.hp.hpl.jena.sparql.algebra.op.OpSlice;
import com.hp.hpl.jena.sparql.algebra.op.OpTable;
import com.hp.hpl.jena.sparql.algebra.op.OpTopN;
import com.hp.hpl.jena.sparql.algebra.op.OpTriple;
import com.hp.hpl.jena.sparql.algebra.op.OpUnion;
import com.hp.hpl.jena.sparql.core.Var;

/**
 * @author Juergen Umbrich (firstname.lastname@deri.org)
 * @date Jun 13, 2011
 */
public class JoinVariableVisitor1 implements OpVisitor {

	Set<Variable> _joinVars = new HashSet<Variable>();
	Set<Variable> _vars = new HashSet<Variable>();
	
	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpBGP)
	 */
	@Override
	public void visit(OpBGP opBGP) {
		// TODO Auto-generated method stub
		
		for(Triple t: opBGP.getPattern()){
			if(Var.isVar(t.getSubject())){
				Variable v = new Variable(t.getSubject().getName());
				if(_vars.contains(v)){
					_joinVars.add(v);
				}else
					_vars.add(v);
			}
			if(Var.isVar(t.getPredicate())){
				Variable v = new Variable(t.getPredicate().getName());
				if(_vars.contains(v)){
					_joinVars.add(v);
				}else
					_vars.add(v);
			}
			if(Var.isVar(t.getObject())){
				Variable v = new Variable(t.getObject().getName());
				if(_vars.contains(v)){
					_joinVars.add(v);
				}else
					_vars.add(v);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpQuadPattern)
	 */
	@Override
	public void visit(OpQuadPattern quadPattern) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpTriple)
	 */
	@Override
	public void visit(OpTriple opTriple) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpPath)
	 */
	@Override
	public void visit(OpPath opPath) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpTable)
	 */
	@Override
	public void visit(OpTable opTable) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpNull)
	 */
	@Override
	public void visit(OpNull opNull) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpProcedure)
	 */
	@Override
	public void visit(OpProcedure opProc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpPropFunc)
	 */
	@Override
	public void visit(OpPropFunc opPropFunc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpFilter)
	 */
	@Override
	public void visit(OpFilter opFilter) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpGraph)
	 */
	@Override
	public void visit(OpGraph opGraph) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpService)
	 */
	@Override
	public void visit(OpService opService) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpDatasetNames)
	 */
	@Override
	public void visit(OpDatasetNames dsNames) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpLabel)
	 */
	@Override
	public void visit(OpLabel opLabel) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpAssign)
	 */
	@Override
	public void visit(OpAssign opAssign) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpExtend)
	 */
	@Override
	public void visit(OpExtend opExtend) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpJoin)
	 */
	@Override
	public void visit(OpJoin opJoin) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpLeftJoin)
	 */
	@Override
	public void visit(OpLeftJoin opLeftJoin) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpUnion)
	 */
	@Override
	public void visit(OpUnion opUnion) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpDiff)
	 */
	@Override
	public void visit(OpDiff opDiff) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpMinus)
	 */
	@Override
	public void visit(OpMinus opMinus) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpConditional)
	 */
	@Override
	public void visit(OpConditional opCondition) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpSequence)
	 */
	@Override
	public void visit(OpSequence opSequence) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpDisjunction)
	 */
	@Override
	public void visit(OpDisjunction opDisjunction) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpExt)
	 */
	@Override
	public void visit(OpExt opExt) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpList)
	 */
	@Override
	public void visit(OpList opList) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpOrder)
	 */
	@Override
	public void visit(OpOrder opOrder) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpProject)
	 */
	@Override
	public void visit(OpProject opProject) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpReduced)
	 */
	@Override
	public void visit(OpReduced opReduced) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpDistinct)
	 */
	@Override
	public void visit(OpDistinct opDistinct) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpSlice)
	 */
	@Override
	public void visit(OpSlice opSlice) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpGroup)
	 */
	@Override
	public void visit(OpGroup opGroup) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hp.hpl.jena.sparql.algebra.OpVisitor#visit(com.hp.hpl.jena.sparql.algebra.op.OpTopN)
	 */
	@Override
	public void visit(OpTopN opTop) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	public Set<Variable> getJoinVariables() {
		// TODO Auto-generated method stub
		return _joinVars;
	}

}
