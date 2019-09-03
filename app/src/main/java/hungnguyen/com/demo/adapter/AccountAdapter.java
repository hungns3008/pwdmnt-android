package hungnguyen.com.demo.adapter;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import hungnguyen.com.demo.R;
import hungnguyen.com.demo.databinding.ItemAccountBinding;
import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.utils.Objects;

public class AccountAdapter extends BaseAdapter<Account, ItemAccountBinding> {

    android.databinding.DataBindingComponent dataBindingComponent;
    Listener listener;

    public AccountAdapter(DataBindingComponent dataBindingComponent, Listener listener) {
        this.dataBindingComponent = dataBindingComponent;
        this.listener = listener;
    }

    @Override
    protected void bind(ItemAccountBinding binding, Account item) {
        binding.setItem(item);
        binding.getRoot().setOnClickListener(v -> {
            listener.onClick(item.getId());
        });
    }

    @Override
    protected boolean areItemsTheSame(Account oldItem, Account newItem) {
        return Objects.equals(oldItem.getId(), newItem.getId());
    }

    @Override
    protected boolean areContentsTheSame(Account oldItem, Account newItem) {
        return true;
    }

    @Override
    protected ItemAccountBinding createBinding(ViewGroup parent, int viewType) {
        ItemAccountBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_account, parent, false, dataBindingComponent);
        return binding;
    }

    public interface Listener {
        void onClick(long accountID);
    }
}
