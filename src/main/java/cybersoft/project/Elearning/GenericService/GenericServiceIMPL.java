package cybersoft.project.Elearning.GenericService;

import cybersoft.project.Elearning.CommonData.AbstractEntity;

public class GenericServiceIMPL<T extends AbstractEntity,ID> implements JpaRepository<T, ID> {

}
