package example.notification.service;

import example.notification.dto.Relation;
import example.notification.exception.ApplicationException;

public interface RelationService {
	
	public abstract Relation getRelation(long relId) throws ApplicationException;
	
}