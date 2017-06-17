package example.test.service;

import example.test.dto.Relation;
import example.test.exception.ApplicationException;

public interface RelationService {
	
	public abstract Relation getRelation(long relId) throws ApplicationException;
	
}