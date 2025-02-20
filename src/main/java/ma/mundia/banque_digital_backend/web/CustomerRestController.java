package ma.mundia.banque_digital_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.mundia.banque_digital_backend.dtos.CustomerDTO;
import ma.mundia.banque_digital_backend.exception.CustomerNotFoundException;
import ma.mundia.banque_digital_backend.services.BankAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public List<CustomerDTO> customers() {
        return bankAccountService.listCustomers();
    }


    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long CustomerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(CustomerId);
    }

    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return bankAccountService.saveCustomerDTO(customer);
    }

    @PutMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        bankAccountService.deleteCustomer(id);
    }

    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return bankAccountService.searchCustomers("%" + keyword + "%");
    }
}
