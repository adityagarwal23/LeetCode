class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        allSource = "\n".join(source)
        double_slash_re = '//.*'
        block_re = '/\*(.|\n)*?\*/'
        reg = '|'.join([double_slash_re, block_re])
        pureSource = re.sub(reg, '', allSource)
        return list(filter(None, pureSource.split('\n')))