package models.visitor;

import models.transport.Auto;
import models.transport.Motorcycle;

public interface Visitor {
    void visit(Motorcycle motorcycle);
    void visit(Auto auto);
}
