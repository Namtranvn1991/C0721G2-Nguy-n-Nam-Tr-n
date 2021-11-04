package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    public void insertService(Service service);

    public Service selectService(int id);

    public List<Service> selectAllServices();

    public void deleteService(int id);

    public void updateService(Service Service);
}
