package com.example.auth_presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.auth_presentation.databinding.FragmentAuthBinding
import com.example.auth_presentation.viewmodel.AuthViewModel

class AuthFragment : Fragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextNameTextChangedListener()
        editTextSurnameTextChangedListener()
        editTextNumberPhoneTextChangedListener()

    }

    private fun editTextNumberPhoneTextChangedListener() {
        binding.etInputNumberPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                //TODO исправить проверку на телефон
                if (s != null && s.trim().isNotBlank() && s.trim().length >= 17) {
                    editTextCleanNumberPhone()
                    checkInputText()
                } else{
                    setEnableFalse()
                }
            }
        })
    }

    private fun editTextSurnameTextChangedListener() {
        val validPattern = "^[а-яА-Я]+$".toRegex()
        binding.etInputSurname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.trim().isNotBlank()) {
                    editTextCleanSurname()
                    if (!s.matches(validPattern)) {
                        binding.etInputSurname.setBackgroundResource(R.drawable.bg_edittext_error)
                        setEnableFalse()
                    } else {
                        binding.etInputSurname.setBackgroundResource(R.drawable.bg_edittext)
                        checkInputText()
                    }
                }else{
                    setEnableFalse()
                }
            }
        })
    }

    private fun checkInputText() {
        if (viewModel.validateInput(
                inputName = binding.etInputName.text.toString(),
                inputSurname = binding.etInputSurname.text.toString(),
                inputNumberPhone = binding.etInputNumberPhone.text.toString()
            )
        ) {
            enableBtEnter()
        }
    }

    private fun setEnableFalse(){
        binding.btEnter.isEnabled = false
    }

    private fun enableBtEnter() {
        binding.btEnter.isEnabled = true
        binding.btEnter.setOnClickListener {
            Toast.makeText(requireContext(), "НАЖАЛИ", Toast.LENGTH_LONG).show()
        }
    }

    private fun editTextNameTextChangedListener() {
        val validPattern = "^[а-яА-Я]+$".toRegex()
        binding.etInputName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.trim().isNotBlank()) {
                    editTextCleanName()
                    if (!s.matches(validPattern)) {
                        binding.etInputName.setBackgroundResource(R.drawable.bg_edittext_error)
                        setEnableFalse()
                    } else {
                        binding.etInputName.setBackgroundResource(R.drawable.bg_edittext)
                        checkInputText()
                    }
                }else{
                    setEnableFalse()
                }
            }
        })
    }

    private fun editTextCleanName() {
        binding.btnClearName.visibility = View.VISIBLE
        binding.btnClearName.setOnClickListener {
            binding.etInputName.text.clear()
            binding.btnClearName.visibility = View.GONE
        }
    }

    private fun editTextCleanSurname() {
        binding.btnClearSurname.visibility = View.VISIBLE
        binding.btnClearSurname.setOnClickListener {
            binding.etInputSurname.text.clear()
            binding.btnClearSurname.visibility = View.GONE
        }
    }

    private fun editTextCleanNumberPhone() {
        binding.btnClearNumberPhone.visibility = View.VISIBLE
        binding.btnClearNumberPhone.setOnClickListener {
            binding.etInputNumberPhone.text?.clear()
            binding.btnClearNumberPhone.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}