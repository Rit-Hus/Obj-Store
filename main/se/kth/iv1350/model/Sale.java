package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.SaleDTO;

/**
 * Represents a sale: date, total, VAT, and list of items.
 */
public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

    public Sale() {
        this.saleDate = LocalDate.now();
    }

    /**
     * Scans new items: increments quantity on existing ones,
     * or adds new items, then updates totals.
     */
    public void scanItems(ArrayList<Item> newItems) {
        for (Item scanned : newItems) {
            boolean found = false;
            for (Item existing : items) {
                if (existing.getItemID().equals(scanned.getItemID())) {
                    existing.incrementQuantity();
                    found = true;
                    break;
                }
            }
            if (!found) {
                items.add(scanned);
            }
        }
        updateTotal();
    }

    private void updateTotal() {
        totalAmount = 0;
        totalVAT = 0;
        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getPrice();
            totalAmount += itemTotal;
            totalVAT += itemTotal * (item.getVat() / 100);
        }
    }

    /**
     * Builds a SaleDTO for integration by converting each model Item into an ItemDTO.
     *
     * @param amountPaid The amount paid by the customer.
     * @return A SaleDTO containing ItemDTOs and sale totals.
     */
    public SaleDTO createSaleDTO(double amountPaid) {
        ArrayList<ItemDTO> dtoItems = new ArrayList<>();
        for (Item item : items) {
            dtoItems.add(new ItemDTO(
                item.getPrice(),
                (int) item.getVat(),
                item.getQuantity(),
                item.getItemID(),
                item.getName(),
                item.getDescription()
            ));
        }
        return new SaleDTO(totalVAT, dtoItems, saleDate, amountPaid, totalAmount);
    }
}
