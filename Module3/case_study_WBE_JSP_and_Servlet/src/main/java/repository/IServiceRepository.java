package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    public boolean insertService(Service service);

    public Service selectService(int id);

    public List<Service> selectAllServices();

    public boolean deleteService(int id);

    public boolean updateService(Service Service);
}
