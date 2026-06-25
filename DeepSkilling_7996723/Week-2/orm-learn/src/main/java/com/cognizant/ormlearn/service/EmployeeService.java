@Transactional
public List<Employee> getAllPermanentEmployees() {
    return employeeRepository.getAllPermanentEmployees();
}