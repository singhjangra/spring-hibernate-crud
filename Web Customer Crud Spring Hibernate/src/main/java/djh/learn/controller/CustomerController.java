package djh.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import djh.learn.entity.Customer;
import djh.learn.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}

	@GetMapping("/list")
	@Transactional
	public String list(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		System.out.println("list of customers" + customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer testCustomer = new Customer();
		model.addAttribute("customer", testCustomer);
		System.out.println("showFormForAdd------");
		return "customer-form";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer myCustomer, BindingResult bindingResult) {
		System.out.println("customer is-------" + myCustomer);
		System.out.println("bindingResult is-------" + bindingResult);
		System.out.println("bindingResult.hasErrors()---" + bindingResult.hasErrors());

		if (bindingResult.hasErrors()) {
			return "customer-form";
		} else {
			try {
				ModelAndView model = new ModelAndView();
				model.addObject("customer", myCustomer);
				customerService.addCustomer(myCustomer);
				System.out.println("addCustomer------" + myCustomer);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "redirect:/customers/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {

		Customer getCustomer = customerService.getCustomerById(customerId);
		model.addAttribute("customer", getCustomer);
		System.out.println("showFormForUpdate------");
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId, Model model) {

		customerService.delete(customerId);

		System.out.println("deleted------");
		return "redirect:/customers/list";
	}
}
