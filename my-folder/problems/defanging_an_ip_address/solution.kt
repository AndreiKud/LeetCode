class Solution {
    fun defangIPaddr(address: String): String {
        var res: String = ""
        address.forEach {
            res += if (it == '.') "[.]" else it
        }
        
        return res
    }
}